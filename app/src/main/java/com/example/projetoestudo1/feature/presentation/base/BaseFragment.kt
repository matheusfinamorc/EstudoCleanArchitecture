package com.example.projetoestudo1.feature.presentation.base

import android.annotation.SuppressLint
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("UnsafeRepeatOnLifecycleDetector")
abstract class BaseFragment: Fragment() {

    /* ----------------------- Fragment observer ----------------------- */

    fun <T: Any?> Fragment.viewLifecycleOwnerObserver(liveData: LiveData<T>, block: (T) -> Unit) {
        liveData.observe(viewLifecycleOwner, {
            block(it)
        })
    }

    fun <T: Any?> Fragment.viewLifecycleOwnerSharedFlow(sharedFlow: SharedFlow<T>, block: (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                sharedFlow.collectLatest {
                    block(it)
                }
            }
        }
    }

    fun <T: Any?> Fragment.viewLifecycleOwnerSharedFlow(block: () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                block()
            }
        }
    }

    fun <T: Any?> Fragment.viewLifecycleOwnerStateFlow(stateFlow: StateFlow<T>, block: (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                stateFlow.collectLatest {
                    block(it)
                }
            }
        }
    }

    /* ----------------------- Keyboard hide function ----------------------- */

    /**
     * metodo responsavel por ocultar o teclado do usuario.
     */
    fun hideKeyboard() = try {
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    } catch (e: Exception) {
        /** Do nothing **/
    }
}