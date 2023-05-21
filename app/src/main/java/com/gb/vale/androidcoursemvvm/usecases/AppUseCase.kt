package com.gb.vale.androidcoursemvvm.usecases

import com.gb.vale.androidcoursemvvm.usecases.preference.IAppPreferences
import com.gb.vale.androidcoursemvvm.utils.EMPTY
import javax.inject.Inject

class AppUseCase @Inject constructor(private val iAppPreference : IAppPreferences) {
    fun logout() = iAppPreference.saveToken(EMPTY)
    fun getToken() = iAppPreference.getToken().isNotEmpty()

}