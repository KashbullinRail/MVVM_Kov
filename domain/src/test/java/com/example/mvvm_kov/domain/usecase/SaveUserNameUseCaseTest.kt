package com.example.mvvm_kov.domain.usecase

import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @Test
    fun `should not save data if name was already saved`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val testParams = SaveUserName(saveName = "test first name")
        val actual = useCase.execute(testParams)
        val expected = true

        Assertions.assertEquals(expected, actual)

        Mockito.verify(userRepository, Mockito.never()).saveName(saveUserName = any())

    }

}