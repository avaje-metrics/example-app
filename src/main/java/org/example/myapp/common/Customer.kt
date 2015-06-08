package org.example.myapp.common

import java.sql.Timestamp

/**
 * Customer bean. With
 */
public class Customer(

  var name: String,

  var email: String
){

  var lastUpdate: Timestamp? = null

}