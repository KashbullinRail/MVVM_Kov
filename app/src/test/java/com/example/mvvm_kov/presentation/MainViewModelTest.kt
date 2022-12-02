package com.example.mvvm_kov.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.usecase.GetUserNameUseCase
import com.example.mvvm_kov.domain.usecase.SaveUserNameUseCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class MainViewModelTest {

    val getUserNameUseCase = mock<GetUserNameUseCase>()
    val saveUserNameUseCase = mock<SaveUserNameUseCase>()

    @AfterEach
    fun afterEach() {
        Mockito.reset(getUserNameUseCase)
        Mockito.reset(saveUserNameUseCase)
        ArchTaskExecutor.getInstance().setDelegate(null)
    }

    @Before
    fun beforeEach() {
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) {
                runnable.run()
            }

            override fun postToMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun executeOnMainThread(runnable: Runnable) {
                runnable.run()
            }

            override fun isMainThread(): Boolean {
                return true
            }
        })

    }

    @Test
    fun `sould save username and return true`() {

        val saveResult = true
        val testSaveText = "Test user name"
        val testParams = SaveUserName(saveName = testSaveText)

        Mockito.`when`(saveUserNameUseCase.execute(userName = testParams))
            .thenReturn(saveResult)

        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )

        viewModel.save(text = testSaveText)

        val expected = "Save result = true"
        val actual = viewModel.resultLiveData.value

        Mockito.verify(saveUserNameUseCase, Mockito.times(1))
            .execute(userName = testParams)
        Assertions.assertEquals(expected, actual)

    }

    @Test
    fun `sould save username and return false`() {

        val saveResult = false
        val testSaveText = "Test user name"
        val testParams = SaveUserName(saveName = testSaveText)

        Mockito.`when`(saveUserNameUseCase.execute(userName = testParams))
            .thenReturn(saveResult)

        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )

        viewModel.save(text = testSaveText)

        val expected = "Save result = false"
        val actual = viewModel.resultLiveData.value

        Mockito.verify(saveUserNameUseCase, Mockito.times(1))
            .execute(userName = testParams)
        Assertions.assertEquals(expected, actual)

    }

    @Test
    fun `sould load username`() {

        val testUserName = UserName(
            firstName = "Test first name",
            lastName = "Test last name"
        )


        Mockito.`when`(getUserNameUseCase.execute()).thenReturn(testUserName)

        val viewModel = MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )

        val expected = "${testUserName.firstName} ${testUserName.lastName}"
        val actual = viewModel.resultLiveData.value

        Assertions.assertEquals(expected, actual)

    }

}