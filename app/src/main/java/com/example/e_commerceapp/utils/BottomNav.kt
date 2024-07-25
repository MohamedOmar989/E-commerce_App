package com.example.e_commerceapp.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.e_commerceapp.AccountScreen
import com.example.e_commerceapp.CategoriesScreen
import com.example.e_commerceapp.HomeScreen
import com.example.e_commerceapp.ProductsListScreen
import com.example.e_commerceapp.WishlistScreen
import com.example.e_commerceapp.ui.theme.primaryBlue

@Composable
fun EcomBottomAppBar(navController: NavController, ){


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(60.dp)
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        containerColor = primaryBlue,
        windowInsets = WindowInsets.navigationBars
    ) {

        NavigationBar(modifier = Modifier.fillMaxWidth(1f),
            containerColor = Color.Transparent
        ) {

            NavigationBarItem(
                selected =  currentDestination?.hierarchy?.any {
                    it.route == HomeScreen().route } == true,

                onClick = {

                    navController.navigate(HomeScreen().route) {
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true




                    }
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = primaryBlue),
                icon = {

                    if (currentDestination?.hierarchy?.any {
                            it.route == HomeScreen().route } == true) {
                        Image(
                            painter = painterResource(id = HomeScreen().navBarTabItem!!.selectedIcon),
                            contentDescription = HomeScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = HomeScreen().navBarTabItem!!.unSelectedIcon),
                            contentDescription = HomeScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                })

            NavigationBarItem(
                selected =  currentDestination?.hierarchy?.any {
                    val index = 0
                    val categoryId = ""
                    it.route == "${CategoriesScreen().route}/${index}"

                } == true,

                onClick = {

                    navController.navigate("${CategoriesScreen().route}/${0}") {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true


                    }
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = primaryBlue),
                icon = {

                    if (currentDestination?.hierarchy?.any {
                            it.route == "${CategoriesScreen().route}/{index}"

                                    || it.route == "${ProductsListScreen().route}/{categoryId}"} == true) {

                        Image(
                            painter = painterResource(id = CategoriesScreen().navBarTabItem!!.selectedIcon),
                            contentDescription = CategoriesScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = CategoriesScreen().navBarTabItem!!.unSelectedIcon),
                            contentDescription = CategoriesScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)

                        )
                    }

                })


            NavigationBarItem(
                selected =  currentDestination?.hierarchy?.any {
                    val index = 0
                    val categoryId = ""
                    it.route == WishlistScreen().route

                } == true,

                onClick = {

                    navController.navigate(WishlistScreen().route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true


                    }
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = primaryBlue),
                icon = {

                    if (currentDestination?.hierarchy?.any {
                            it.route == WishlistScreen().route } == true) {

                        Image(
                            painter = painterResource(id = WishlistScreen().navBarTabItem!!.selectedIcon),
                            contentDescription = CategoriesScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = WishlistScreen().navBarTabItem!!.unSelectedIcon),
                            contentDescription = CategoriesScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)

                        )
                    }

                })

            NavigationBarItem(
                selected =  currentDestination?.hierarchy?.any {
                    val index = 0
                    val categoryId = ""
                    it.route == AccountScreen().route

                } == true,

                onClick = {

                    navController.navigate(WishlistScreen().route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true


                    }
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = primaryBlue),
                icon = {

                    if (currentDestination?.hierarchy?.any {
                            it.route == AccountScreen().route } == true) {

                        Image(
                            painter = painterResource(id = AccountScreen().navBarTabItem!!.selectedIcon),
                            contentDescription = AccountScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = AccountScreen().navBarTabItem!!.unSelectedIcon),
                            contentDescription = AccountScreen().navBarTabItem!!.title,
                            modifier = Modifier.size(40.dp)

                        )
                    }

                })


        }



    }

}