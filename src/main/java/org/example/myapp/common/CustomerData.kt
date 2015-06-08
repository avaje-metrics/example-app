package org.example.myapp.common

import java.sql.Timestamp

/**
 * Simple data class example.
 */
public data class CustomerData (

    val name: String,

    val email: String = "na", // default

    val lastUpdate: Timestamp = Timestamp(System.currentTimeMillis()) // default
)
