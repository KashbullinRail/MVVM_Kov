package com.example.mvvm_kov.domain.usecase

import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


//class TestRepository: UserRepository {
//    override fun saveName(saveUserName: SaveUserName): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun getName(): UserName {
//        return UserName(firstName = "test first name", lastName = "test last name")
//    }
//
//}


class GetUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @Test
    fun `sould return the same data as in repository`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
       Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test first name", lastName = "test last name")

        Assertions.assertEquals(expected, actual)


    }


}