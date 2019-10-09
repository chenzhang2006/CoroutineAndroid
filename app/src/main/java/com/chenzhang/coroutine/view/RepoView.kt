package com.chenzhang.coroutine.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.chenzhang.coroutine.R
import kotlinx.android.synthetic.main.repo_view.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class RepoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.repo_view, this)
    }

    @ModelProp
    fun bindModel(model: Model) {
        repo_id.text = model.repoId.toString()
        repo_name.text = model.repoName
    }

    data class Model(
        val repoId: Long,
        val repoName: String
    )
}