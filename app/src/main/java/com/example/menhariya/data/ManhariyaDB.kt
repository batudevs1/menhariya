package com.example.menhariya.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class,Ticket::class), version = 1)
 abstract  class ManhariyaDB: RoomDatabase() {

    abstract fun userDao():UserDao
    abstract fun ticketDao():TicketDao

    companion object {

        @Volatile
        private var INSTANCE: ManhariyaDB? = null

        fun getDatabase(context: Context): ManhariyaDB {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ManhariyaDB::class.java, "manhariya_db"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}


