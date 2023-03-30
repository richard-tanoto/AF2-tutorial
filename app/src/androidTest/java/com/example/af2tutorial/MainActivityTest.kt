package com.example.af2tutorial

import android.app.Application
import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.af2tutorial.data.User
import com.example.af2tutorial.data.UserDatabase
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var db: UserDatabase

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Before
    fun init() {
        val application = ApplicationProvider.getApplicationContext<Application>()
        mainViewModel = MainViewModel(application)
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = UserDatabase.getDatabase(context)
    }

    @Test
    @Throws(Exception::class)
    fun insertFavoriteUser() {
        //Dummy user for comparison
        val user = User(
            id = 0,
            firstName = "Richard",
            lastName = "Tanoto",
            avatar = "contoh url",
            email = "richard@bangkit.academy",
            isFavorite = true
        )

        //Add to favorite
        onView(withId(R.id.btnFav)).perform(click())
        //User to be tested
        var test = mainViewModel.findUser("Richard")
        //Check if the favorite user exist
        assertThat(test, equalTo(user))

        //Remove from favorite
        onView(withId(R.id.btnFav)).perform(click())
        //User to be tested
        test = mainViewModel.findUser("Richard")
        //Check if the favorite user exist
        assertThat(test, equalTo(null))
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}