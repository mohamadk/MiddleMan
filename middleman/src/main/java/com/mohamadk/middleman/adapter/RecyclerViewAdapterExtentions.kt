package com.mohamadk.middleman.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mohamadk.middleman.model.ModelTypes

fun createItemView(
    viewType: Int
    , inflater: LayoutInflater
    , parent: ViewGroup
): View {

    val (_, defaultResLayout, defaultViewClass, modelClass) = ModelTypes.types.find {
        it.type == viewType
    } ?: throw IllegalStateException("didn't found the view Type :$viewType")

    return when {
        defaultResLayout != null -> inflate(inflater, defaultResLayout, parent)
        defaultViewClass != null -> try {
            defaultViewClass.getConstructor(Context::class.java).newInstance(
                parent.context
            ) as View
        } catch (classCastException: ClassCastException) {
            throw IllegalStateException(
                "class that you pass in defaultViewClass method in your model must return " +
                        "a class with type of View but instead it returns $defaultViewClass"
            )
        } catch (noSuchMethodException: NoSuchMethodException) {
            try {
                defaultViewClass.getConstructor(
                    Context::class.java,
                    AttributeSet::class.java,
                    Int::class.java
                ).newInstance(
                    parent.context,
                    null,
                    0
                ) as View
            } catch (noSuchMethodException: NoSuchMethodException) {
                throw IllegalStateException(
                    """please make sure your custom item view have a constructor with only context as an argument
                    |for example
                    |CustomItemView(val context:Context){}
                """.trimMargin()
                )
            }
        }
        else -> throw IllegalStateException(
            "Please implement defaultResLayout or defaultView in $modelClass model"
        )
    }
}

private fun inflate(inflater: LayoutInflater, resLayout: Int, parent: ViewGroup): View {
    return inflater.inflate(
        resLayout,
        parent,
        false
    )
}
