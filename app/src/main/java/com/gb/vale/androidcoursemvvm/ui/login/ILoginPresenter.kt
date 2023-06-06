package com.gb.vale.androidcoursemvvm.ui.login

import com.gb.vale.androidcoursemvvm.ui.model.User

interface ILoginPresenter {
    fun successLogin(user : User?)
}