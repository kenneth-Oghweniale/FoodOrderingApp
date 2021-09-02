package com.kenneth.foodorderingapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kenneth.foodorderingapp.models.CartModel

@Database(
    entities = [CartModel::class],
    version = 1
)

abstract class CartDataBase: RoomDatabase() {
//    abstract fun cartDao(): CartDAO
    abstract fun cartDao(): CartDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CartDataBase? = null

        fun getDatabase(context: Context): CartDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartDataBase::class.java,
                    "cart-database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}

