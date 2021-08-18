package github.com.githubrepo.ui.adapter

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.FragmentActivity
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import github.com.githubrepo.R
import github.com.githubrepo.model.Results
import kotlinx.android.synthetic.main.list_github.view.*

class GithubAdapter(var activity: FragmentActivity?, var results: ArrayList<Results>) :
    RecyclerView.Adapter<GithubAdapter.RepoHolder>() {

    inner class RepoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfile: AppCompatImageView = itemView.ivProfile
        val txtRepoName: AppCompatTextView = itemView.txt_title
        val txtGender: AppCompatTextView = itemView.txt_Gender
        val txtAge: AppCompatTextView = itemView.txt_Age
        val txtAddress: AppCompatTextView = itemView.txt_Address
        val btnAccept: Button = itemView.btn_accept
        val btnDecline: Button = itemView.btn_decline
    }

    lateinit var listener: (results: Results) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_github, parent, false)
        return RepoHolder(view)
    }

    fun setData(list: ArrayList<Results>) {
        results.addAll(list)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        val item = this.results[position]
        holder.txtRepoName.text =
            "Name : " + item.name.title + " " + item.name.first + " " + item.name.last
        holder.txtGender.text = "Gender: " + item.gender
        holder.txtAge.text = "Age: " + item.dob.age.toString()
        holder.txtAddress.text =
            "Add.: " + item.location.city + "," + item.location.state + "," + item.location.country

        Glide.with(activity!!).load(item.picture.medium.trim()).into(holder.ivProfile)

        holder.btnAccept.tag = this
        holder.btnDecline.tag = this

        when (getPosition(position)) {
            "Member Accepted" -> {
                holder.btnAccept.text = "Member Accepted"
                holder.btnDecline.text = "Decline"
            }
            "Member Decline" -> {
                holder.btnAccept.text = "Accept"
                holder.btnDecline.text = "Member Decline"
            }
            else -> {
                holder.btnAccept.text = "Accept"
                holder.btnDecline.text = "Decline"
            }

        }

        holder.btnAccept.setOnClickListener {
            savePosition(position, "Member Accepted")
            holder.btnAccept.text = "Member Accepted"
            holder.btnDecline.text = "Decline"
        }
        holder.btnDecline.setOnClickListener {
            savePosition(position, "Member Decline")
            holder.btnDecline.text = "Member Decline"
            holder.btnAccept.text = "Accept"
        }
    }

    private fun savePosition(key: Int, value: String) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(key.toString(), value)
        editor.apply()
    }

    private fun getPosition(key: Int): String? {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity)
        return prefs.getString(key.toString(), "")
    }

}