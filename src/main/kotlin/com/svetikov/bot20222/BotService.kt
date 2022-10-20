package com.svetikov.bot20222

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.ivmg.telegram.bot
import me.ivmg.telegram.dispatch
import me.ivmg.telegram.dispatcher.command
import me.ivmg.telegram.dispatcher.text
import me.ivmg.telegram.network.fold
import org.springframework.beans.factory.BeanCreationException


import org.springframework.stereotype.Service

@Service
class BotService {

    var bot = bot {
        token = "5786686686:AAGy4DHunxKpqim0CV9IbB6bONr2hevoW4o"
    }

    init {
        bot.startPolling()
    }

    suspend fun launchBot() {
        val text = "Hello"
        val bot = bot {


            token = "5786686686:AAGy4DHunxKpqim0CV9IbB6bONr2hevoW4o"
            dispatch {

                text { bot, u ->
                    bot.sendMessage(422698441, text)
                    println(u.message)
                }
//                command("start") {bot,_->
//
//                    val result = bot.sendMessage(422698441, text = "Hi there!")
//                    result.fold({
//                        // do something here with the response
//                    },{
//                        println("Error")
//                    })
//                }
            }
        }
        bot.startPolling()
    }

    suspend fun dispatcherApi(text: String): String {
        bot.sendMessage(422698441, text)
        return text
//       bot {
//            dispatch {
//                text { bot, u ->
//                    bot.sendMessage(422698441, "text")
//                    println(u.message)
//                }
//            }
//        }
    }
}