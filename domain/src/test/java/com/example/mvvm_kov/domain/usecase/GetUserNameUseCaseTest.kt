package com.example.mvvm_kov.domain.usecase

import com.example.mvvm_kov.domain.models.SaveUserName
import com.example.mvvm_kov.domain.models.UserName
import com.example.mvvm_kov.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class TestRepository: UserRepository {
    override fun saveName(saveUserName: SaveUserName): Boolean {
        TODO("Not yet implemented")
    }

    override fun getName(): UserName {
        return UserName(firstName = "test first name", lastName = "test last name")
    }

}


class GetUserNameUseCaseTest {


    @Test
    fun `sould return the same data as in repository`() {

        val testRepository = TestRepository()

        val useCase = GetUserNameUseCase(userRepository = testRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test first name", lastName = "test last name")

        Assertions.assertEquals(expected, actual)


    }


}