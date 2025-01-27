package com.example.e_commerceapp.wishlist

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Token
import com.example.domain.contract.repository.CartRepository
import com.example.domain.contract.repository.WishlistRepository
import com.example.domain.model.products.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(private val wishlistRepository: WishlistRepository,
                                            private  val cartRepository: CartRepository
):ViewModel() {

    val wishlist = mutableStateListOf<ProductItem?>()


    fun getWishlist(){

        viewModelScope.launch {

            val response = wishlistRepository.getWishlist(Token.token!!)




            if (response!=null && response.status.equals("success")){

                wishlist.clear()
                wishlist.addAll(response.data!!)
                wishlist.forEach {
                }
            }
        }
    }



    fun removeProductFromWishlist(productId:String){

        viewModelScope.launch {


            wishlistRepository.removeProductFromWishlist(Token.token?:"",productId)




        }
    }

    fun addToCart(productId: String){

        viewModelScope.launch {




            cartRepository.addProductToCart(Token.token!!,productId)

            removeProductFromWishlist(productId)

        }

    }
}