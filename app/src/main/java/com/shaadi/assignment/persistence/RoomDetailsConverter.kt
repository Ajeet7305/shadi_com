package com.shaadi.assignment.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shaadi.assignment.model.*
import java.lang.reflect.Type

class IntegerListConverter {

  @TypeConverter
  fun stringFromObjectUser(list: UserStats?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }


  @TypeConverter
  fun getObjectFromStringUser(jsonString: String?): UserStats {
    val listType: Type = object : TypeToken<UserStats?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectUser(list: List<UserStats?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }


  @TypeConverter
  fun getListObjectFromStringUser(jsonString: String?): List<UserStats?>? {
    val listType: Type = object : TypeToken<ArrayList<UserStats?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromObjectCoordinate(list: Coordinates?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringCoordinate(jsonString: String?): Coordinates? {
    val listType: Type = object : TypeToken<Coordinates?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectCoordinate(list: List<Coordinates?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringCoordinate(jsonString: String?): List<Coordinates?>? {
    val listType: Type = object : TypeToken<ArrayList<Coordinates?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromObjectDob(list: Dob?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringDob(jsonString: String?): Dob? {
    val listType: Type = object : TypeToken<Dob?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectDob(list: List<Dob?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringDob(jsonString: String?): List<Dob?>? {
    val listType: Type = object : TypeToken<ArrayList<Dob?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }


  @TypeConverter
  fun stringFromObjectId(list: Id?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringId(jsonString: String?): Id? {
    val listType: Type = object : TypeToken<Id?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectId(list: List<Id?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringId(jsonString: String?): List<Id?>? {
    val listType: Type = object : TypeToken<ArrayList<Id?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromObjectInfo(list: Info?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringInfo(jsonString: String?): Info? {
    val listType: Type = object : TypeToken<Info?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectInfo(list: List<Info?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringInfo(jsonString: String?): List<Info?>? {
    val listType: Type = object : TypeToken<ArrayList<Info?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }


  @TypeConverter
  fun stringFromObjectLocation(list: Location?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringLocation(jsonString: String?): Location? {
    val listType: Type = object : TypeToken<Location?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectLocation(list: List<Location?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringLocation(jsonString: String?): List<Location?>? {
    val listType: Type = object : TypeToken<ArrayList<Location?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }


  @TypeConverter
  fun stringFromObjectLogin(list: Login?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringLogin(jsonString: String?): Login? {
    val listType: Type = object : TypeToken<Login?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectLogin(list: List<Login?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringLogin(jsonString: String?): List<Login?>? {
    val listType: Type = object : TypeToken<ArrayList<Login?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }


  @TypeConverter
  fun stringFromObjectPicture(list: Picture?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringPicture(jsonString: String?): Picture? {
    val listType: Type = object : TypeToken<Picture?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectPicture(list: List<Picture?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringPicture(jsonString: String?): List<Picture?>? {
    val listType: Type = object : TypeToken<ArrayList<Picture?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }


  @TypeConverter
  fun stringFromObjectRegistered(list: Registered?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringRegistered(jsonString: String?): Registered? {
    val listType: Type = object : TypeToken<Registered?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectRegistered(list: List<Registered?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringRegistered(jsonString: String?): List<Registered?>? {
    val listType: Type = object : TypeToken<ArrayList<Registered?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }


  @TypeConverter
  fun stringFromObjectStreet(list: Street?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringStreet(jsonString: String?): Street? {
    val listType: Type = object : TypeToken<Street?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectStreet(list: List<Street?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringStreet(jsonString: String?): List<Street?>? {
    val listType: Type = object : TypeToken<ArrayList<Street?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromObjectTimezone(list: Timezone?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringTimezone(jsonString: String?): Timezone? {
    val listType: Type = object : TypeToken<Timezone?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectTimezone(list: List<Timezone?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringTimezone(jsonString: String?): List<Timezone?>? {
    val listType: Type = object : TypeToken<ArrayList<Timezone?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }


  @TypeConverter
  fun stringFromObjectName(list: Name?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getObjectFromStringName(jsonString: String?): Name? {
    val listType: Type = object : TypeToken<Name?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }

  @TypeConverter
  fun stringFromListObjectName(list: List<Name?>?): String? {
    val gson = Gson()
    return gson.toJson(list)
  }

  @TypeConverter
  fun getListObjectFromStringName(jsonString: String?): List<Name?>? {
    val listType: Type = object : TypeToken<ArrayList<Name?>?>() {}.type
    return Gson().fromJson(jsonString, listType)
  }
}
