package com.gb.vale.androidcoursemvvm.usecases


import com.gb.vale.androidcoursemvvm.usecases.repository.preference.IAppPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import javax.inject.Inject

class AppUseCase @Inject constructor(private val IAppPreference : IAppPreferences) {
    fun logout() = IAppPreference.saveToken(EMPTY)
    fun getToken() = IAppPreference.getToken()

}