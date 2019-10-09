package com.chenzhang.coroutine.view

import android.util.Log
import com.airbnb.epoxy.TypedEpoxyController
import com.chenzhang.coroutine.data.Repo

class RepoController : TypedEpoxyController<List<Repo>>() {
    override fun buildModels(data: List<Repo>) {
        data.forEach {
            //            val repoViewModel = RepoView.Model(it.id, it.name)
            repoView {
                Log.d("Controller", "build model for [${it.name}]")
                id("repoViewId${it.id}")
//                bindModel(repoViewModel)
                repoId(it.id.toString())
                name(it.name)
            }
        }
    }
}