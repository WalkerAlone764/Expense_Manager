package com.upsideDownDev.expensemanager.data.repository

import android.util.Log
import com.upsideDownDev.expensemanager.domain.model.CountryDetail
import com.upsideDownDev.expensemanager.domain.repository.CountryListRepository
import java.util.Currency
import java.util.Locale

class CountryListRepositoryImpl: CountryListRepository {


    override fun getAllCountryList(): List<CountryDetail> {

        val list = mutableListOf<CountryDetail>()


        val locale = Locale.getAvailableLocales()
        locale.forEach {
            try {

                it?.apply {
                    val new = CountryDetail(
                        countryName = displayCountry,
                        countryCode = country,
                        countryFlag = getEmojiFlag(country),
                        countryCurrency = Currency.getInstance(this).currencyCode,
                        countryCurrencyDisplay = Currency.getInstance(this).displayName
                    )
                    list.add(new)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                Log.d("is worked", "yes")
            }


        }

       return list
    }

     private fun getEmojiFlag(country: String): String {
        val firstLetter = Character.codePointAt(country, 0) - 0x41 + 0x1F1E6
        val secondLetter = Character.codePointAt(country, 1) - 0x41 + 0x1F1E6
        return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
    }
}