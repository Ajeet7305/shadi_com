package github.com.githubrepo.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import github.com.githubrepo.R
import github.com.githubrepo.model.Results
import github.com.githubrepo.ui.adapter.GithubAdapter
import github.com.githubrepo.viewModel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.reflect.Type

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    lateinit var githubAdapter: GithubAdapter
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        if (isOnline()) {
            viewModel.setCount("10")
        } else {
            val arrayList = fetchArrayList("Cards")
            displayCards(arrayList)
            return
        }

        viewModel.user.observe(viewLifecycleOwner, { userProfile ->

            displayCards(userProfile.results as ArrayList<Results>)
        })
    }

    private fun displayCards(results: ArrayList<Results>) {

        try {
            clearSharedPreference()
            saveArrayList(results, "Cards")

            githubAdapter = GithubAdapter(activity, results)
            rvGithubs.setHasFixedSize(true)
            rvGithubs.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            rvGithubs.adapter = githubAdapter

            githubAdapter.listener = {
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

    private fun saveArrayList(list: ArrayList<Results>, key: String?) {
        try {
            val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
            val editor: SharedPreferences.Editor = prefs.edit()
            val gson = Gson()
            val json: String = gson.toJson(list)
            editor.putString(key, json)
            editor.apply()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun fetchArrayList(key: String): ArrayList<Results> {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        val gson = Gson()
        val yourArrayList: ArrayList<Results>
        val json = prefs.getString(key, "")

        yourArrayList = when {
            json.isNullOrEmpty() -> ArrayList()
            else -> gson.fromJson(json, object : TypeToken<List<Results>>() {}.type)
        }

        return yourArrayList
    }

    fun clearSharedPreference() {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.apply()
    }

    private fun isOnline(): Boolean {
        val connectivityManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

}