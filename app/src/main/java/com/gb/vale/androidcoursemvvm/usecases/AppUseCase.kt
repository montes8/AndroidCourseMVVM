package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.repository.preferences.api.AppPreference
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import javax.inject.Inject

class AppUseCase @Inject constructor(
    private val appRepositoryPreference: AppPreference
) {

    fun logout() = appRepositoryPreference.saveToken(EMPTY)


    fun getLoginValidate()  = appRepositoryPreference.getToken().isNotEmpty()

}