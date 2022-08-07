package com.example.makepizza.presentation.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.makepizza.data.model.SaleModel
import com.example.makepizza.data.model.content.ContentModel
import com.example.makepizza.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val interactor: MenuInteractor
) : BaseViewModel() {
    private val _salesList = MutableLiveData<List<SaleModel>>()
    val salesList: LiveData<List<SaleModel>> = _salesList

    private val _content = MutableLiveData<List<ContentModel>>()
    val content: LiveData<List<ContentModel>> = _content

    private val _action = MutableLiveData<MenuAction>()
    val action: LiveData<MenuAction> = _action

    init {
        load()
    }

    fun load() {

//        load(_content){
//            interactor.getContent()
//        }

        viewModelScope.launch {
            try {
                _salesList.postValue(interactor.getSales())
                _content.postValue(interactor.getContent())
            } catch (e: Throwable) {
                _action.value = MenuAction.ShowError("Нестабильное соединение")
            }
            _action.value = MenuAction.HideLoader
        }
    }

    sealed class MenuAction {
        object HideLoader : MenuAction()
        data class ShowError(val errorMessage: String) : MenuAction()
    }
}