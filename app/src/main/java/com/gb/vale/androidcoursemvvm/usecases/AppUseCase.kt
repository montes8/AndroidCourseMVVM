package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.usecases.preference.IAppPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY

class AppUseCase (private val IAppPreference : IAppPreferences) {
    fun logout() = IAppPreference.saveToken(EMPTY)
    fun getToken() = IAppPreference.getToken().isNotEmpty()

}