package com.example.infonatest.presentation.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.infonatest.presentation.model.BenevitModel
import com.example.infonatest.presentation.model.ItemModel
import com.example.infonatest.presentation.view.adapter.ParentAdp
import kotlinx.coroutines.launch

class BenevitsViewModel: ViewModel() {
    private lateinit var adapter: ParentAdp
    var adpParent: MutableLiveData<ParentAdp> = MutableLiveData()
    fun loadBenevits(){
        viewModelScope.launch {
            val item1 = listOf(
                ItemModel(
                    img = "https://firebasestorage.googleapis.com/v0/b/stagingpagatodo-286214.appspot.com/o/Challenge%2Flogo-bbva.jpeg?alt=media&token=435ed70e-061b-4a80-a216-c69cea04f068",
                    name = "bbva",
                    label = "BBVA Bancomer Creando Oportunidades",
                    locked = false
                ),
                ItemModel(
                    img = "https://firebasestorage.googleapis.com/v0/b/stagingpagatodo-286214.appspot.com/o/Challenge%2Flogo.scotiabank.jpg?alt=media&token=1029cc0b-7bff-4f5c-90f7-d96ca60f9619",
                    name = "scotiabank",
                    label = "Scotiabank Creando Tú decides, Nosotros te Asesoramos",
                    locked = true
                ),
                ItemModel(
                    img = "https://firebasestorage.googleapis.com/v0/b/stagingpagatodo-286214.appspot.com/o/Challenge%2Flogo-citi.png?alt=media&token=da97f3ad-34b2-4f7d-ae59-3169238993c7",
                    name = "citi",
                    label = "Citibanamex, lo mejor de México, lo mejor del mundo.",
                    locked = false
                )
            )
            val item2 = listOf(
                ItemModel(
                    img = "https://firebasestorage.googleapis.com/v0/b/stagingpagatodo-286214.appspot.com/o/Challenge%2Flogo-pagatodo.jpeg?alt=media&token=38b6ac4d-85ac-4288-bada-88eb5a0dec20",
                    name = "paga todo",
                    label = "Banco Paga Todo es Para Todos",
                    locked = false
                ),
                ItemModel(
                    img = "https://firebasestorage.googleapis.com/v0/b/stagingpagatodo-286214.appspot.com/o/Challenge%2Flogo-banregio.png?alt=media&token=ae605bda-5698-4bf8-9639-d4fdc9579b5c",
                    name = "banregio",
                    label = "Banregio: Somos el banco de creadores",
                    locked = true
                ),
                ItemModel(
                    img = "https://firebasestorage.googleapis.com/v0/b/stagingpagatodo-286214.appspot.com/o/Challenge%2Flogo-citi.png?alt=media&token=da97f3ad-34b2-4f7d-ae59-3169238993c7",
                    name = "citi",
                    label = "Citibanamex, lo mejor de México, lo mejor del mundo.",
                    locked = false
                )
            )
            val list = listOf(
                BenevitModel(
                    title = "Title",
                    items = item1

                ),
                BenevitModel(
                    title = "Title",
                    items = item2

                ),
                BenevitModel(
                    title = "Title",
                    items = item1

                ),
            )

            var models = mutableListOf<BenevitModel>()
            for (i in list) {
                models.add(i)
            }
            adapter = ParentAdp(models)
            adpParent.postValue(adapter)
        }
    }
}