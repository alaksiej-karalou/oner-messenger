package com.github.aliakseikaraliou.oner.sms.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.github.aliakseikaraliou.oner.base.models.conversation.ConversationPreview
import com.github.aliakseikaraliou.oner.base.view.ConversationPreviewFragment
import com.github.aliakseikaraliou.oner.sms.di.component.SmsConversationPreviewComponent
import com.github.aliakseikaraliou.oner.sms.ui.SmsConversationPreviewModel.DataLoaded
import com.github.aliakseikaraliou.oner.sms.ui.vm.SmsConversationPreviewViewModel
import javax.inject.Inject

class SmsConversationPreviewFragment : ConversationPreviewFragment() {
    @Inject
    lateinit var viewModel: SmsConversationPreviewViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SmsConversationPreviewComponent.inject(this)

        viewModel.liveData.observe(viewLifecycleOwner, Observer { previewModel ->
            when (previewModel) {
                is DataLoaded -> dataLoaded(previewModel.data)
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loadConversationPreviews()
    }

    private fun dataLoaded(data: List<ConversationPreview>) {
        TODO("Not yet implemented")
    }

}