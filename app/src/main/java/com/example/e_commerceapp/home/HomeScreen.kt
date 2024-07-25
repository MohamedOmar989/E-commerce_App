package com.example.e_commerceapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerceapp.R
import com.example.e_commerceapp.ui.theme.primaryBlue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.e_commerceapp.ui.theme.blueTextColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.example.e_commerceapp.utils.DotsIndicator


@Composable
fun HomeScreenContent(viewModel: HomeViewModel = viewModel(),onCategoryClick:(index:Int)->Unit,onViewAllClick:()->Unit){

    Column {

        DiscountAds()
        CategoriesGrid(viewModel, onCategoryClick, onViewAllClick)

    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DiscountAds(){

    val state = rememberPagerState()

    val slideImage = remember { mutableStateOf<Int>(R.drawable.speaker_dis) }


    Box (contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .padding(end = 17.dp)
            .fillMaxWidth(1f)) {

        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(1f),
            count = 3,
            state = state
        ) { page ->
            when (page) {

                0 -> {
                    slideImage.value = R.drawable.speaker_dis
                }

                1 -> {
                    slideImage.value = R.drawable.makeup_dis
                }

                2 -> {
                    slideImage.value = R.drawable.electronics_dis
                }
            }


            Image(
                painterResource(slideImage.value),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(1f),
                contentScale = ContentScale.FillWidth
            )
        }
        DotsIndicator(
            totalDots = 3,
            selectedIndex = state.currentPage,
            selectedColor = primaryBlue,
            unSelectedColor = Color.White,
        )
    }





}



@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoriesGrid(viewModel: HomeViewModel,onCategoryClick:(index:Int)->Unit,onViewAllClick:()->Unit){

    LaunchedEffect(key1 = Unit){

        if (viewModel.categoriesList.isNullOrEmpty()){
            viewModel.getCategories()
        }

    }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top=20.dp, bottom = 20.dp, end = 17.dp)
    ) {
        Text(text = "Categories",color = blueTextColor, fontSize = 18.sp)

        Spacer(modifier = Modifier.weight(1f))

        Text(text = "view all",
            color = blueTextColor,
            fontSize = 12.sp,
            modifier = Modifier.clickable {
                onViewAllClick()
            })
    }

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxHeight(0.7f)
        ,
        //  verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(17.dp
        ),
        content = {

            items(viewModel.categoriesList.size){

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        onCategoryClick(it)
                    }
                ){
                    GlideImage(
                        model = viewModel.categoriesList[it]?.image,
                        contentDescription = viewModel.categoriesList[it]?.name,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(80.dp),
                        contentScale = ContentScale.Crop)

                    Text(
                        text = viewModel.categoriesList[it]?.name?:"",
                        color = blueTextColor,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 15.sp,
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .width(90.dp)
                    )

                }

            }

        })
}