package com.example.e_commerceapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.model.products.ProductItem
import com.example.e_commerceapp.cart.CartDetailsActivity
import com.example.e_commerceapp.categories.CategoriesScreenContent
import com.example.e_commerceapp.categories.CategoriesViewModel
import com.example.e_commerceapp.categories.ProductListContent
import com.example.e_commerceapp.home.HomeScreenContent
import com.example.e_commerceapp.home.HomeViewModel
import com.example.e_commerceapp.productdetails.ProductDetails
import com.example.e_commerceapp.ui.theme.EcommerceAppTheme
import com.example.e_commerceapp.utils.EcomBottomAppBar
import com.example.e_commerceapp.utils.EcomTopAppBar
import com.example.e_commerceapp.wishlist.WishListContent
import com.example.e_commerceapp.wishlist.WishlistViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity(), HomeNavigator {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val token =  intent.getStringExtra("token")


        setContent {
            EcommerceAppTheme {
                // A surface container using the 'background' color from the theme
                ApplicationTabs(this)
            }
        }
    }

    override fun navigateToProductDetails(productItem: ProductItem) {

        val intent = Intent(this,ProductDetails::class.java)
        intent.putExtra("updateCartProduct",productItem)
        startActivity(intent)
    }

    override fun navigateToCart() {
        val intent = Intent(this,CartDetailsActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun ApplicationTabs(navigator: HomeNavigator) {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            EcomTopAppBar(){
                navigator.navigateToCart()
            }
        }, bottomBar = {
            EcomBottomAppBar (
                navController = navController,



                )
        }

    ) {
        Column(
            modifier =
            Modifier
                .padding(
                    top = it.calculateTopPadding() + 20.dp,
                    start = 17.dp,
                    bottom = it.calculateBottomPadding()
                )
                .fillMaxWidth(1f)
        ) {

            Screens(navController,navigator)


        }


    }


}



@Composable
fun Screens(navController : NavHostController,navigator: HomeNavigator){



    NavHost(navController = navController, startDestination = HomeScreen().route){

        composable(HomeScreen().route){

            val viewModel = hiltViewModel<HomeViewModel>()

            HomeScreenContent(viewModel,
                onCategoryClick =   {index->
                    navController.navigate(
                        route = "${CategoriesScreen().route}/${index}")
                },
                onViewAllClick =   {

                    navController.navigate("${CategoriesScreen().route}/${0}")
                })


        }

        composable(
            route = "${CategoriesScreen().route}/{index}",
            arguments = listOf(navArgument("index"){

                type = NavType.IntType
            })
        ){
            val viewModel = hiltViewModel<HomeViewModel>()

            val index = it.arguments?.getInt("index")

            BackHandler {

                navController.navigateUp()
            }
            CategoriesScreenContent(viewModel,index){categoryId->

                navController.navigate("${ProductsListScreen().route}/${categoryId}")
            }

        }

        composable(
            route = "${ProductsListScreen().route}/{categoryId}",
            arguments = listOf(navArgument("categoryId"){

                type = NavType.StringType
            })
        ){ it ->
            val viewModel = hiltViewModel<CategoriesViewModel>()

            val categoryId = it.arguments?.getString("categoryId")

            ProductListContent(
                viewModel,
                categoryId,
                navigateToProductDetails = {productItem->

                    navigator.navigateToProductDetails(productItem)
                })

        }

        composable(
            route = WishlistScreen().route

        ){
            val viewModel = hiltViewModel<WishlistViewModel>()

            BackHandler {

                navController.navigateUp()
            }

            WishListContent(viewModel)



        }

        composable(
            route = AccountScreen().route

        ){

            BackHandler {

                navController.navigateUp()
            }

            AccountScreenContent()



        }

    }


}

interface HomeNavigator{

    fun navigateToProductDetails(productItem: ProductItem)
    fun navigateToCart()
}
