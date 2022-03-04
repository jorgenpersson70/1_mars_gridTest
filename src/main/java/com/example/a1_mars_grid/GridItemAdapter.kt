package com.example.a1_mars_grid

import android.graphics.Color
import android.media.MediaPlayer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList


//var arrayOfRows = Array(9) {Array(9) {0} }
//var arrayOfColumns = Array(9) {Array(9) {0} }

var arrayOfRows = Array(9) {ArrayList<Int>(Collections.nCopies(9, 0)) }
var arrayOfColumns = Array(9) {ArrayList<Int>(Collections.nCopies(9, 0)) }


var Winner = 0
var player : Int = 1
var chatTextRecieved = ""

var row0 = Array(17) {0}

/*var row1Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var row2Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var row3Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var row4Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var row5Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var row6Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var row7Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var row8Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))*/

var row1Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var row2Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var row3Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var row4Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var row5Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var row6Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var row7Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var row8Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))


/*
var row1Temp = ArrayList(17) {0}
var row2Temp = ArrayList(17) {0}
var row3Temp = ArrayList(17) {0}
var row4Temp = ArrayList(17) {0}
var row5Temp = ArrayList(17) {0}
var row6Temp = ArrayList(17) {0}
var row7Temp = ArrayList(17) {0}
var row8Temp = ArrayList(17) {0}*/



var colorColumn0 = Array(9) {0}
var lastDropRed = Array(9) {0}
var lastDropGreen = Array(9) {0}

/*var column1Temp = Array(9) {0}
var column2Temp = Array(9) {0}
var column3Temp = Array(9) {0}
var column4Temp = Array(9) {0}
var column5Temp = Array(9) {0}
var column6Temp = Array(9) {0}
var column7Temp = Array(9) {0}
var column8Temp = Array(9) {0}*/

/*var column1Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var column2Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var column3Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var column4Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var column5Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var column6Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var column7Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))
var column8Temp: ArrayList<Int> = ArrayList<Int>(Collections.nCopies(17, 0))*/

var column1Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var column2Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var column3Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var column4Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var column5Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var column6Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var column7Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))
var column8Temp: ArrayList<Int> = ArrayList(mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))

//deckOfCardsValue = ArrayList(mutableListOf(2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11))


//column1Temp[1] = row1Temp[i]

var checkForNumbers = 4
var putAnywereFlag = false
var blockRead = false



class GridItemAdapter(val cardTitles : Array<String>, val cardImages: Array<String>):

 //   var mediaPlayer : MediaPlayer? = null



    RecyclerView.Adapter<GridItemAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardImage : ImageView = itemView.findViewById(R.id.cardImage)
        val cardView : CardView = itemView.findViewById(R.id.cardView)
  //      val cardTitle : TextView = itemView.findViewById(R.id.cardTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
  /*      for (i in 0..8) {
            onBindViewHolder(holder, i)
        }*/

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   //     holder.cardTitle.text = cardTitles[position]

   //     flip_dealercard2.setImageDrawable(getDrawable(randomCardsIntValue[0].name))

    //    Picasso.get().load(cardImages[position]).into(holder.cardImage)
      //  holder.cardImage.setImageDrawable(R.drawable.rectred)
 //       click.setImageDrawable(getDrawable(R.drawable.rectred))

 //       Picasso.get().load("https://picsum.photos/seed/picsum/200/300").into(holder.cardImage)

 /*       if (position < 8){
    holder.cardImage.visibility = View.INVISIBLE
    holder.cardImage.setPadding(0,0,0,0)
    holder.cardView.layout(0,0,0,0)
}*/

        holder.cardImage.setBackgroundColor(Color.WHITE)
        holder.itemView.setOnClickListener {
            Log.i("size", "getFourRandomCards " + position.toString())

            if (player == 1) {
                player = 2
                holder.cardImage.setBackgroundColor(Color.GREEN)
                holder.cardView.setCardBackgroundColor(Color.MAGENTA)
    //            holder.cardImage.setImageDrawable(R.drawable.rectgreen)

                holder.cardImage.setImageResource(R.drawable.rectgreen)

                var positionRow = position / 8

                // testa så här
      //          positionRow += 1

                var positionColumn = (position % 8) + 1

                Log.i("size", "Row " + positionRow.toString())
                Log.i("size", "Column " + positionColumn.toString())
                arrayOfRows[positionRow][positionColumn] = 1
                arrayOfColumns[positionColumn][positionRow] = 1
            }
            else
            {
                player = 1
                holder.cardImage.setBackgroundColor(Color.RED)
               holder.cardView.setCardBackgroundColor(Color.CYAN)
    //            holder.cardImage.setImageDrawable(getDrawable(R.drawable.rectred))
                holder.cardImage.setImageResource(R.drawable.rectred)

                var positionRow = position / 8

                var positionColumn = (position % 8) + 1

                Log.i("size", "Row " + positionRow.toString())
                Log.i("size", "Column " + positionColumn.toString())
                arrayOfRows[positionRow][positionColumn] = 2
                arrayOfColumns[positionColumn][positionRow] = 2

            }

            checkRows()
            checkColumns()
            checkDiagonal1()
            checkDiagonal2()

        }
    }

    override fun getItemCount(): Int {
        return cardImages.size
    }



    fun checkRows(){

      //  for (i in 1..8)
            for (i in 0..7)
        {
            test(arrayOfRows[i], 0, false, true)
        }
    }

    fun checkColumns()
    {
 //       print("------columns------")
        for (i in 1..8){
            test(arrayOfColumns[i], 9, false, false)
        }
    }

    fun copyRowToColumn2(i: Int){
        Log.i("size", "Winner i "+ i.toString())
        column1Temp[1] = row1Temp[i]
        column1Temp[2] = row2Temp[i]
        column1Temp[3] = row3Temp[i]
        column1Temp[4] = row4Temp[i]
        column1Temp[5] = row5Temp[i]
        column1Temp[6] = row6Temp[i]
        column1Temp[7] = row7Temp[i]
        column1Temp[8] = row8Temp[i]
        Log.i("size", "column1Temp 1 "+ column1Temp[1].toString())
        Log.i("size", "column1Temp 2 "+ column1Temp[2].toString())
        Log.i("size", "column1Temp 3 "+ column1Temp[3].toString())
        Log.i("size", "column1Temp 4 "+ column1Temp[4].toString())
        Log.i("size", "column1Temp 5 "+ column1Temp[5].toString())
        Log.i("size", "column1Temp 6 "+ column1Temp[6].toString())
        Log.i("size", "column1Temp 7 "+ column1Temp[7].toString())
        Log.i("size", "column1Temp 8 "+ column1Temp[8].toString())
    }

 //   fun test(rad: Array<Int>, column: Int, copyRowToColumn: Boolean, rowOrColumnNumber : Int){
 //fun test(rad: ArrayList<Int>, column: Int, copyRowToColumn: Boolean, rowOrColumnNumber : Int){
 fun test(rad: ArrayList<Int>, column: Int, copyRowToColumn: Boolean, checkRow : Boolean){
        var inRowRed = 0
        var inRowGreen = 0
   //     var rad2:[Int] = rad
        var rad2:ArrayList<Int> = rad
        var firstInRow = 0


    //    var hej = MainActivity()

     //   hej.testar()

 //       print("-------test rad-----")
  //      print(rad)

        if (copyRowToColumn == true){
            copyRowToColumn2(column)
            rad2 = column1Temp
            for (i in 1..8){
     //       for (i in 0..7){
                if (rad2[i] == 1){

                    inRowGreen += 1

                    if (inRowGreen >= checkForNumbers){
   //                     winner(color:"Grön", column: column)
                        Log.i("size", "Winner")
                        Winner = 1
                    }
                }
                else{
                    inRowGreen = 0
                }
                if (rad2[i] == 2){

                    inRowRed += 1

                    if (inRowRed >= checkForNumbers){
  //                      winner(color:"Röd", column: column)
                        Log.i("size", "Winner")
                        Winner = 2
                    }
                }
                else{
                    inRowRed = 0
                }
            }
        }else{
            // Check row and check column will enter here
            // When I check rows then Column enters as value 0, when I check column the Column enters as value 9

                if (checkRow)
                {
                    for (i in 1..8) {
                        //      for (i in 0..7){
                        if (inRowRed == 1) {
                            firstInRow = i
                        }
                        if (inRowGreen == 1) {
                            firstInRow = i
                        }

                        if (rad[i] == 1) {

                            inRowGreen += 1

                            if (inRowGreen >= checkForNumbers) {
                                //                     print("First \(firstInRow-1)")
                                //                     print("Last \(i)")

                                //                    winner(color:"Grön", column: column)
                                Log.i("size", "Winner")
                                Winner = 1
                            }
                        } else {
                            inRowGreen = 0
                        }
                        if (rad[i] == 2) {

                            inRowRed += 1

                            if (inRowRed >= checkForNumbers) {
                                //                     print("First \(firstInRow-1)")
                                //                    print("Last \(i)")

                                //                    winner(color:"Röd", column: column)
                                Log.i("size", "Winner")
                                Winner = 2
                            }
                        } else {
                            inRowRed = 0
                        }
                    }
                }
                else
                {
                  //  for (i in 1..8) {
                        for (i in 0..7)
                        {
                        if (inRowRed == 1) {
                            firstInRow = i
                        }
                        if (inRowGreen == 1) {
                            firstInRow = i
                        }

                        if (rad[i] == 1) {

                            inRowGreen += 1

                            if (inRowGreen >= checkForNumbers) {
                                //                     print("First \(firstInRow-1)")
                                //                     print("Last \(i)")

                                //                    winner(color:"Grön", column: column)
                                Log.i("size", "Winner")
                                Winner = 1
                            }
                        } else {
                            inRowGreen = 0
                        }
                        if (rad[i] == 2) {

                            inRowRed += 1

                            if (inRowRed >= checkForNumbers) {
                                //                     print("First \(firstInRow-1)")
                                //                    print("Last \(i)")

                                //                    winner(color:"Röd", column: column)
                                Log.i("size", "Winner")
                                Winner = 2
                            }
                        } else {
                            inRowRed = 0
                        }
                    }
                }
        }
    }

    fun startNewRound() {

 /*       arrayOfRows.removeAll()
        arrayOfColumns.removeAll()
        createArrays()

        theWinningColor.isEnabled = false
        theWinningColor.alpha = 0

        andTheWinnerIs.backgroundColor = .clear

                myTableView.reloadData()*/
    }

    fun createArrays(){
 //       andTheWinnerIs.text = ""
  //      theWinningColor.isEnabled = false
  //      theWinningColor.alpha = 0

        row0 = Array(17) {0}

/*        arrayOfRows.app(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)*/

        colorColumn0 = Array(9) {0}

 /*       arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)*/

    }

    fun copyRowToTemp(){
        row1Temp = arrayOfRows[0]
     //   row1Temp = arrayOfRows[1]
        Log.i("size", "row1Temp 0 " + row1Temp[0].toString())
        Log.i("size", "row1Temp 1 " + row1Temp[1].toString())
        Log.i("size", "row1Temp 2 " + row1Temp[2].toString())
        Log.i("size", "row1Temp 3 " + row1Temp[3].toString())
        Log.i("size", "row1Temp 4 " + row1Temp[4].toString())
        Log.i("size", "row1Temp 5 " + row1Temp[5].toString())
        Log.i("size", "row1Temp 6 " + row1Temp[6].toString())
        Log.i("size", "row1Temp 7 " + row1Temp[7].toString())
        Log.i("size", "row1Temp 8 " + row1Temp[8].toString())

        row2Temp = arrayOfRows[1]
        Log.i("size", "row1Temp 0 " + row2Temp[0].toString())
        Log.i("size", "row1Temp 1 " + row2Temp[1].toString())
        Log.i("size", "row1Temp 2 " + row2Temp[2].toString())
        Log.i("size", "row1Temp 3 " + row2Temp[3].toString())
        Log.i("size", "row1Temp 4 " + row2Temp[4].toString())
        Log.i("size", "row1Temp 5 " + row2Temp[5].toString())
        Log.i("size", "row1Temp 6 " + row2Temp[6].toString())
        Log.i("size", "row1Temp 7 " + row2Temp[7].toString())
        Log.i("size", "row1Temp 8 " + row2Temp[8].toString())

        row3Temp = arrayOfRows[2]

        Log.i("size", "row1Temp 0 " + row3Temp[0].toString())
        Log.i("size", "row1Temp 1 " + row3Temp[1].toString())
        Log.i("size", "row1Temp 2 " + row3Temp[2].toString())
        Log.i("size", "row1Temp 3 " + row3Temp[3].toString())
        Log.i("size", "row1Temp 4 " + row3Temp[4].toString())
        Log.i("size", "row1Temp 5 " + row3Temp[5].toString())
        Log.i("size", "row1Temp 6 " + row3Temp[6].toString())
        Log.i("size", "row1Temp 7 " + row3Temp[7].toString())
        Log.i("size", "row1Temp 8 " + row3Temp[8].toString())

        row4Temp = arrayOfRows[3]

        Log.i("size", "row1Temp 0 " + row4Temp[0].toString())
        Log.i("size", "row1Temp 1 " + row4Temp[1].toString())
        Log.i("size", "row1Temp 2 " + row4Temp[2].toString())
        Log.i("size", "row1Temp 3 " + row4Temp[3].toString())
        Log.i("size", "row1Temp 4 " + row4Temp[4].toString())
        Log.i("size", "row1Temp 5 " + row4Temp[5].toString())
        Log.i("size", "row1Temp 6 " + row4Temp[6].toString())
        Log.i("size", "row1Temp 7 " + row4Temp[7].toString())
        Log.i("size", "row1Temp 8 " + row4Temp[8].toString())

        row5Temp = arrayOfRows[4]
        row6Temp = arrayOfRows[5]
        row7Temp = arrayOfRows[6]
        row8Temp = arrayOfRows[7]
    }

    /*
    fun getFourRandomCards_anvander_vi_denna(): ArrayList<String> {
        var cardList = ArrayList<String>()

        Log.i("size", "getFourRandomCards ")
        if(iteration < numberOfCards) {
            cardList.add(deckOfCards[iteration])
            cardList.add(deckOfCards[++iteration])
            cardList.add(deckOfCards[++iteration])
            cardList.add(deckOfCards[++iteration])

            iteration++
        }

        return cardList
    }*/

    // use arrayone.subList(1) instead of arrayListOf(arrayone.removeAt(0))
// removeAt returns the removed element. You're making a new list with one element, the element you removed.

  //  fun removeInRow(antal:Int, radin:[Int])->[Int]{
  //fun removeInRow(antal: Int, radin: Array<Int>)->Array<Int>{
  fun removeInRow(antal: Int, radin: ArrayList<Int>): ArrayList<Int>{
// jag pekar nog rakt in i min array som jag inte skall ändra i        var rad = radin
      var cardList = ArrayList<Int>()

      for (i in 0..8){
          cardList.add(radin[i])
      }

        for (i in 1..antal){
  //          rad.remove(at: 0)
    //        rad.removeAt(0)

            Log.i("size", "rad drop 0 " + cardList[0])
            Log.i("size", "rad drop 1 " + cardList[1])
            Log.i("size", "rad drop 2 " + cardList[2])
            Log.i("size", "rad drop 3 " + cardList[3])
            Log.i("size", "rad drop 4 " + cardList[4])
            Log.i("size", "rad drop 5 " + cardList[5])
            Log.i("size", "rad drop 6 " + cardList[6])
            Log.i("size", "rad drop 7 " + cardList[7])

         //   rad.drop(0)
   //         rad.removeAt(0)
            cardList[0] = cardList[1]
            cardList[1] = cardList[2]
            cardList[2] = cardList[3]
            cardList[3] = cardList[4]
            cardList[4] = cardList[5]
            cardList[5] = cardList[6]
            cardList[6] = cardList[7]
            cardList[7] = cardList[8]
//            rad[8] = rad[9]

            Log.i("size", "rad drop 0 " + cardList[0])
            Log.i("size", "rad drop 1 " + cardList[1])
            Log.i("size", "rad drop 2 " + cardList[2])
            Log.i("size", "rad drop 3 " + cardList[3])
            Log.i("size", "rad drop 4 " + cardList[4])
            Log.i("size", "rad drop 5 " + cardList[5])
            Log.i("size", "rad drop 6 " + cardList[6])
            Log.i("size", "rad drop 7 " + cardList[7])

        }
        return cardList
    }

  //  fun removeInRow(antal: Int, radin: ArrayList<Int>): ArrayList<Int>{
  //  fun insertInRow(antal:Int, rad:[Int])->[Int]{
  fun insertInRow(antal: Int, radin: ArrayList<Int>): ArrayList<Int>{
    //    var rad = rad
      var cardList = ArrayList<Int>()

      for (i in 0..8){
          cardList.add(radin[i])
      }

        for (i in 1..antal){
  //          rad.insert(0, at: 0)

            Log.i("size", "rad drop 0 " + cardList[0])
            Log.i("size", "rad drop 1 " + cardList[1])
            Log.i("size", "rad drop 2 " + cardList[2])
            Log.i("size", "rad drop 3 " + cardList[3])
            Log.i("size", "rad drop 4 " + cardList[4])
            Log.i("size", "rad drop 5 " + cardList[5])
            Log.i("size", "rad drop 6 " + cardList[6])
            Log.i("size", "rad drop 7 " + cardList[7])

            cardList[8] = cardList[7]
            cardList[7] = cardList[6]
            cardList[6] = cardList[5]
            cardList[5] = cardList[4]
            cardList[4] = cardList[3]
            cardList[3] = cardList[2]
            cardList[2] = cardList[1]
            cardList[1] = cardList[0]

            cardList[0] = 0


            Log.i("size", "rad drop 0 " + cardList[0])
            Log.i("size", "rad drop 1 " + cardList[1])
            Log.i("size", "rad drop 2 " + cardList[2])
            Log.i("size", "rad drop 3 " + cardList[3])
            Log.i("size", "rad drop 4 " + cardList[4])
            Log.i("size", "rad drop 5 " + cardList[5])
            Log.i("size", "rad drop 6 " + cardList[6])
            Log.i("size", "rad drop 7 " + cardList[7])


        }
   //     return rad
      return cardList
    }


    fun testDiagonal(rad: ArrayList<Int>, column: Int, diagonalOneOrTwo: Int, rowOrColumnNumber : Int, start : Int){
        var inRowRed = 0
        var inRowGreen = 0
     //   var rad2:[Int] = rad
        var rad2:ArrayList<Int> = rad
        var firstGreenInColumn = 0
        var firstRedInColumn = 0
        var firstMark = 0
        var Hole = 0
        var Rest = 0

        copyRowToColumn2(column)
        rad2 = column1Temp

 //       print("här har vi columntemp \(column1Temp)")
        //      print("Rad \(rad2)")
        for (i in 1..8){
   //     for (i in 0..7){
            if (rad2[i] == 1){
                firstRedInColumn = 0
                if (firstGreenInColumn == 0){
                    firstGreenInColumn = i
                }
                inRowGreen += 1

                if (inRowGreen >= checkForNumbers){
  //                  print("firstGreenInColumn: \(firstGreenInColumn)")
   //                 print("i: \(i)")

    //                winner(color:"Grön", column: column)
                    Log.i("size", "Winner")
                    Winner = 1
                }
            }
            else{
                inRowGreen = 0
            }
            if (rad2[i] == 2){
                firstGreenInColumn = 0
                if (firstRedInColumn == 0){
                    firstRedInColumn = i
                }
                inRowRed += 1
                // if (inRowRed > 3){
                if (inRowRed >= checkForNumbers){
    //                print("firstRedInColumn: \(firstRedInColumn)")
     //               print("i: \(i)")

     //               winner(color:"Röd", column: column)
                    Log.i("size", "Winner")
                    Winner = 2
                }
            }
            else{
                inRowRed = 0
            }
        }
    }

    fun checkDiagonal1(){
        var sameColor = 0

        copyRowToTemp()
   /*     row2Temp[0]=1
        row2Temp[1]=2
        row2Temp[2]=3
        row2Temp[3]=4
        row2Temp[4]=5
        row2Temp[5]=6
        row2Temp[6]=7
        row2Temp[7]=8
        row2Temp[8]=9*/

        Log.i("size", "row " + row2Temp[1].toString())
        row2Temp = removeInRow(1, row2Temp)
        Log.i("size", "row " + row2Temp[1].toString())
        row3Temp = removeInRow(2, row3Temp)
        row4Temp = removeInRow(3, row4Temp)
        row5Temp = removeInRow(4, row5Temp)
        row6Temp = removeInRow(5, row6Temp)
        row7Temp = removeInRow(6, row7Temp)
        row8Temp = removeInRow(7, row8Temp)

     /*   print(row1Temp)
        print(row2Temp)
        print(row3Temp)
        print(row4Temp)
        print(row5Temp)
        print(row6Temp)
        print(row7Temp)
        print(row8Temp)*/


        for (i in 1..8){
            testDiagonal(column1Temp, i, 1, i, 1)
        }


        copyRowToTemp()

    //    row1Temp = Array(17) {0}
        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row3Temp = removeInRow(1, row3Temp)
        row4Temp = removeInRow(2, row4Temp)
        row5Temp = removeInRow(3, row5Temp)
        row6Temp = removeInRow(4, row6Temp)
        row7Temp = removeInRow(5, row7Temp)
        row8Temp = removeInRow(6, row8Temp)

        for (i in 1..8){
            testDiagonal(column1Temp, i, 1, i, 2)
        }



        copyRowToTemp()

   //     row1Temp = Array(17) {0}
   //     row2Temp = Array(17) {0}

        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row2Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row4Temp = removeInRow(1, row4Temp)
        row5Temp = removeInRow(2, row5Temp)
        row6Temp = removeInRow(3, row6Temp)
        row7Temp = removeInRow(4, row7Temp)
        row8Temp = removeInRow(5, row8Temp)

        for (i in 1..8){
            testDiagonal(column1Temp, i, 1, i, 3)
        }


        copyRowToTemp()

   /*     row1Temp = Array(17) {0}
        row2Temp = Array(17) {0}
        row3Temp = Array(17) {0}*/

        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row2Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row3Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row5Temp = removeInRow(1, row5Temp)
        row6Temp = removeInRow(2, row6Temp)
        row7Temp = removeInRow(3, row7Temp)
        row8Temp = removeInRow(4, row8Temp)

        for (i in 1..8){
            testDiagonal(column1Temp, i, 1, i, 4)
        }


        copyRowToTemp()

    /*    row1Temp = Array(17) {0}
        row2Temp = Array(17) {0}
        row3Temp = Array(17) {0}
        row4Temp = Array(17) {0}*/

        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row2Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row3Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row4Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row6Temp = removeInRow(1, row6Temp)
        row7Temp = removeInRow(2, row7Temp)
        row8Temp = removeInRow(3, row8Temp)

    /*    print(row1Temp)
        print(row2Temp)
        print(row3Temp)
        print(row4Temp)
        print(row5Temp)
        print(row6Temp)
        print(row7Temp)
        print(row8Temp)*/

        for (i in 1..8){
            testDiagonal(column1Temp, i, 1, i, 5)
        }
    }

    fun checkDiagonal2(){
        var sameColor = 0

        copyRowToTemp()

        row2Temp = insertInRow(1, row2Temp)
        row3Temp = insertInRow(2, row3Temp)
        row4Temp = insertInRow(3, row4Temp)
        row5Temp = insertInRow(4, row5Temp)
        row6Temp = insertInRow(5, row6Temp)
        row7Temp = insertInRow(6, row7Temp)
        row8Temp = insertInRow(7, row8Temp)

   /*     print(row1Temp)
        print(row2Temp)
        print(row3Temp)
        print(row4Temp)
        print(row5Temp)
        print(row6Temp)
        print(row7Temp)
        print(row8Temp)*/

        for (i in 1..8){
            testDiagonal(column1Temp, i, 2, i, 1)
        }

        copyRowToTemp()

     //   row1Temp = Array(repeating: 0, count: 17)
        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row3Temp = insertInRow(1, row3Temp)
        row4Temp = insertInRow(2, row4Temp)
        row5Temp = insertInRow(3, row5Temp)
        row6Temp = insertInRow(4, row6Temp)
        row7Temp = insertInRow(5, row7Temp)
        row8Temp = insertInRow(6, row8Temp)

        for (i in 1..8){
            testDiagonal(column1Temp, i, 2, i, 2)
        }

        copyRowToTemp()

  //      row1Temp = Array(repeating: 0, count: 17)
  //      row2Temp = Array(repeating: 0, count: 17)

        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row2Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row4Temp = insertInRow(1, row4Temp)
        row5Temp = insertInRow(2, row5Temp)
        row6Temp = insertInRow(3, row6Temp)
        row7Temp = insertInRow(4, row7Temp)
        row8Temp = insertInRow(5, row8Temp)

        for (i in 1..8){
            testDiagonal(column1Temp, i, 2, i, 3)
        }

        copyRowToTemp()

    /*    row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)
        row3Temp = Array(repeating: 0, count: 17)*/

        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row2Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row3Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row5Temp = insertInRow(1, row5Temp)
        row6Temp = insertInRow(2, row6Temp)
        row7Temp = insertInRow(3, row7Temp)
        row8Temp = insertInRow(4, row8Temp)

        for (i in 1..8){
            testDiagonal(column1Temp, i, 2, i, 4)
        }

        copyRowToTemp()

   /*     row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)
        row3Temp = Array(repeating: 0, count: 17)
        row4Temp = Array(repeating: 0, count: 17)*/

        row1Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row2Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row3Temp = ArrayList<Int>(Collections.nCopies(17, 0))
        row4Temp = ArrayList<Int>(Collections.nCopies(17, 0))

        row6Temp = insertInRow(1, row6Temp)
        row7Temp = insertInRow(2, row7Temp)
        row8Temp = insertInRow(3, row8Temp)

        for (i in 1..8){
            testDiagonal(column1Temp, i, 2, i, 5)
        }
    }


}

/*


var arrayOfRows = [[Int]]()
var arrayOfColumns = [[Int]]()
var player : Int = 1
var chatTextRecieved = ""
// igen

class ViewController: UIViewController, UICollectionViewDelegate, UICollectionViewDataSource, UITextFieldDelegate, UICollectionViewDelegateFlowLayout {

    @IBOutlet weak var whosTurnText: UILabel!

    @IBOutlet weak var myTableView: UICollectionView!
    @IBOutlet weak var TurnShowColor: UILabel!
    @IBOutlet weak var andTheWinnerIs: UILabel!
    @IBOutlet weak var theWinningColor: UILabel!
    @IBOutlet weak var fourInRowButtonText: UIButton!
    @IBOutlet weak var fiveInRowButtonText: UIButton!
    @IBOutlet weak var putAnywere: UIButton!
    @IBOutlet weak var putFromBottom: UIButton!
    @IBOutlet weak var beginAgainButton: UIButton!

    let reuseIdentifier = "cell" // also enter this string as the cell identifier in the storyboard

    var row0 : [Int] = Array(repeating: 0, count: 17)

    var row1Temp = Array(repeating: 0, count: 17)
    var row2Temp = Array(repeating: 0, count: 17)
    var row3Temp = Array(repeating: 0, count: 17)
    var row4Temp = Array(repeating: 0, count: 17)
    var row5Temp = Array(repeating: 0, count: 17)
    var row6Temp = Array(repeating: 0, count: 17)
    var row7Temp = Array(repeating: 0, count: 17)
    var row8Temp = Array(repeating: 0, count: 17)

    var colorColumn0 : [Int] = Array(repeating: 0, count: 9)
    var lastDropRed = Array(repeating: 0, count: 9)
    var lastDropGreen = Array(repeating: 0, count: 9)

    var column1Temp = Array(repeating: 0, count: 9)
    var column2Temp = Array(repeating: 0, count: 9)
    var column3Temp = Array(repeating: 0, count: 9)
    var column4Temp = Array(repeating: 0, count: 9)
    var column5Temp = Array(repeating: 0, count: 9)
    var column6Temp = Array(repeating: 0, count: 9)
    var column7Temp = Array(repeating: 0, count: 9)
    var column8Temp = Array(repeating: 0, count: 9)
    var checkForNumbers = 4
    var putAnywereFlag = false
    var blockRead = false
    var height = 0.0
    var width = 0.0
    let edge    : CGFloat = 10.0
    let spacing : CGFloat = 10.0


    override func viewDidLoad() {
        super.viewDidLoad()

        self.view.backgroundColor = UIColor(patternImage: UIImage(named: "wood1.png")!)

        TurnShowColor.backgroundColor = .green
        andTheWinnerIs.backgroundColor = .clear

        player = 1

        fourInRowButtonText.backgroundColor = .systemPurple
        fiveInRowButtonText.backgroundColor = UIColor(named: "FourFiveButtonLight")
        putFromBottom.backgroundColor = .systemPurple
        putAnywere.backgroundColor = UIColor(named: "FourFiveButtonLight")
        beginAgainButton.backgroundColor = .systemPurple

        createArrays()

    }


    func createArrays(){
        andTheWinnerIs.text = ""
        theWinningColor.isEnabled = false
        theWinningColor.alpha = 0

        row0 = Array(repeating: 0, count: 17)

        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)
        arrayOfRows.append(row0)

        colorColumn0 = Array(repeating: 0, count: 9)

        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)
        arrayOfColumns.append(colorColumn0)

    }


    @IBAction func putAnyWere(_ sender: Any) {
        putAnywere.backgroundColor = .systemPurple
        putFromBottom.backgroundColor = UIColor(named: "FourFiveButtonLight")
        putAnywereFlag = true
    }


    @IBAction func putFromBottom(_ sender: Any) {
        putAnywere.backgroundColor = UIColor(named: "FourFiveButtonLight")
        putFromBottom.backgroundColor = .systemPurple
        putAnywereFlag = false
    }

    @IBAction func fourInRowButton(_ sender: Any) {
        fourInRowButtonText.backgroundColor = .systemPurple
        fiveInRowButtonText.backgroundColor = UIColor(named: "FourFiveButtonLight")
        checkForNumbers = 4
        print(player)
    }

    @IBAction func fiveInRowButton(_ sender: Any) {
        fiveInRowButtonText.backgroundColor = .systemPurple
        fourInRowButtonText.backgroundColor = UIColor(named: "FourFiveButtonLight")
        checkForNumbers = 5
    }

    @IBAction func startNewRound(_ sender: Any) {

        arrayOfRows.removeAll()
        arrayOfColumns.removeAll()
        createArrays()

        theWinningColor.isEnabled = false
        theWinningColor.alpha = 0

        andTheWinnerIs.backgroundColor = .clear

        myTableView.reloadData()
    }


       // tell the collection view how many cells to make
       func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
           return 64
       }

       // make a cell for each cell index path
       func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {

           // get a reference to our storyboard cell
           let cell = collectionView.dequeueReusableCell(withReuseIdentifier: reuseIdentifier, for: indexPath as IndexPath) as! MyCollectionViewCell

           cell.myLabel.text = ""



           let indexnumer = indexPath.row

           // första har 0
           print(indexPath.row)
           let rad = (indexPath.row / 8) + 1
           print("rad \(rad)")
           let column = (indexPath.row % 8) + 1
           print("colum \(column)")

           if (arrayOfRows[rad][column] == 1)
           {
               cell.backgroundColor = .green
           }
           if (arrayOfRows[rad][column] == 2)
           {
               cell.backgroundColor = .red
           }
           if (arrayOfRows[rad][column] == 0)
           {
               cell.backgroundColor = .white
           }
           if (arrayOfRows[rad][column] == 3)
           {
               let colorStart = UIColor(red:0.1 , green: 0.2, blue: 0.5, alpha: 1.0)
               let colorEnd = UIColor(red:0.90 , green: 0.40, blue: 0.0, alpha: 0.9)
               cell.backgroundColor = .systemGreen
            }
           if (arrayOfRows[rad][column] == 4)
           {
               let colorStart = UIColor(red:0.1 , green: 0.2, blue: 0.5, alpha: 1.0)
               let colorEnd = UIColor(red:0.90 , green: 0.40, blue: 0.0, alpha: 0.9)
               cell.backgroundColor = .orange
          }

           cell.layer.borderWidth = 1
           cell.layer.cornerRadius = 8

           return cell
       }

       func collectionView(_ collectionView: UICollectionView, didSelectItemAt indexPath: IndexPath) {
           print("You selected cell #\(indexPath.item)!")

            if (theWinningColor.isEnabled){
                return
            }

           let cell = collectionView.cellForItem(at: indexPath)

           let indexnumer = indexPath.row

           // första har 0
           print(indexPath.row)
           let rad = (indexPath.row / 8) + 1
           print("rad \(rad)")
           let column = (indexPath.row % 8) + 1
           print("colum \(column)")

           if (cell?.backgroundColor == .white)
           {
               var lastDropGreenPos : Int = 9
               var lastDropRedPos : Int = 9
               var OK : Bool = false

               if let lastDropGreen = arrayOfColumns[column].firstIndex(of: 1){
                   print("last green \(lastDropGreen)")
                   lastDropGreenPos = lastDropGreen
               }

               if let lastDropRed = arrayOfColumns[column].firstIndex(of: 2){
                   print("last red \(lastDropRed)")
                   lastDropRedPos = lastDropRed
               }

               if (lastDropRedPos < lastDropGreenPos){
                   lastDropGreenPos = lastDropRedPos
                   print("rad \(rad)")
                   print("last red \(lastDropRedPos)")
               }

               if (putAnywereFlag){
                   OK = true
               }else{
                   if ((lastDropGreenPos-1) == rad){
                       print("hej \(lastDropRed)")
                       OK = true
                   }
               }

               if (OK){

                   if (TurnShowColor.backgroundColor == .green)
                   {
                       cell?.backgroundColor = .green
                       TurnShowColor.backgroundColor = .red
                       arrayOfRows[rad][column] = 1
                       arrayOfColumns[column][rad] = 1
                   }
                   else
                   {
                       cell?.backgroundColor = .red
                       TurnShowColor.backgroundColor = .green
                       arrayOfRows[rad][column] = 2
                       arrayOfColumns[column][rad] = 2
                   }
               }
           }
           print("The row1:", arrayOfRows[1])
           print("The row1:", arrayOfRows[2])
           print("The row1:", arrayOfRows[3])
           print("The row1:", arrayOfRows[4])
           print("The row1:", arrayOfRows[5])
           print("The row1:", arrayOfRows[6])
           print("The row1:", arrayOfRows[7])
           print("The row8:", arrayOfRows[8])

           checkRows()
           checkColumns()
           checkDiagonal1()
           checkDiagonal2()
       }


    func removeInRow(antal:Int, rad:[Int])->[Int]{
        var rad = rad
        for i in 1...antal{
            rad.remove(at: 0)
        }
        return rad
    }

    func insertInRow(antal:Int, rad:[Int])->[Int]{
        var rad = rad
        for i in 1...antal{
            rad.insert(0, at: 0)
        }
        return rad
    }

    func copyRowToColumn2(i: Int){
        column1Temp[1] = row1Temp[i]
        column1Temp[2] = row2Temp[i]
        column1Temp[3] = row3Temp[i]
        column1Temp[4] = row4Temp[i]
        column1Temp[5] = row5Temp[i]
        column1Temp[6] = row6Temp[i]
        column1Temp[7] = row7Temp[i]
        column1Temp[8] = row8Temp[i]
    }

    func copyRowToTemp(){
        row1Temp = arrayOfRows[1]
        row2Temp = arrayOfRows[2]
        row3Temp = arrayOfRows[3]
        row4Temp = arrayOfRows[4]
        row5Temp = arrayOfRows[5]
        row6Temp = arrayOfRows[6]
        row7Temp = arrayOfRows[7]
        row8Temp = arrayOfRows[8]
    }

    func checkDiagonal1(){
        var sameColor = 0

        copyRowToTemp()

        row2Temp = removeInRow(antal: 1, rad: row2Temp)
        row3Temp = removeInRow(antal: 2, rad: row3Temp)
        row4Temp = removeInRow(antal: 3, rad: row4Temp)
        row5Temp = removeInRow(antal: 4, rad: row5Temp)
        row6Temp = removeInRow(antal: 5, rad: row6Temp)
        row7Temp = removeInRow(antal: 6, rad: row7Temp)
        row8Temp = removeInRow(antal: 7, rad: row8Temp)

        print(row1Temp)
        print(row2Temp)
        print(row3Temp)
        print(row4Temp)
        print(row5Temp)
        print(row6Temp)
        print(row7Temp)
        print(row8Temp)


        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 1, rowOrColumnNumber: i, start : 1)
        }


        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)

        row3Temp = removeInRow(antal: 1, rad: row3Temp)
        row4Temp = removeInRow(antal: 2, rad: row4Temp)
        row5Temp = removeInRow(antal: 3, rad: row5Temp)
        row6Temp = removeInRow(antal: 4, rad: row6Temp)
        row7Temp = removeInRow(antal: 5, rad: row7Temp)
        row8Temp = removeInRow(antal: 6, rad: row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 1, rowOrColumnNumber: i, start : 2)
        }



        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)
        row4Temp = removeInRow(antal: 1, rad: row4Temp)
        row5Temp = removeInRow(antal: 2, rad: row5Temp)
        row6Temp = removeInRow(antal: 3, rad: row6Temp)
        row7Temp = removeInRow(antal: 4, rad: row7Temp)
        row8Temp = removeInRow(antal: 5, rad: row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 1, rowOrColumnNumber: i, start : 3)
        }


        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)
        row3Temp = Array(repeating: 0, count: 17)
        row5Temp = removeInRow(antal: 1, rad: row5Temp)
        row6Temp = removeInRow(antal: 2, rad: row6Temp)
        row7Temp = removeInRow(antal: 3, rad: row7Temp)
        row8Temp = removeInRow(antal: 4, rad: row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 1, rowOrColumnNumber: i, start : 4)
        }


        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)
        row3Temp = Array(repeating: 0, count: 17)
        row4Temp = Array(repeating: 0, count: 17)
        row6Temp = removeInRow(antal: 1, rad: row6Temp)
        row7Temp = removeInRow(antal: 2, rad: row7Temp)
        row8Temp = removeInRow(antal: 3, rad: row8Temp)

        print(row1Temp)
        print(row2Temp)
        print(row3Temp)
        print(row4Temp)
        print(row5Temp)
        print(row6Temp)
        print(row7Temp)
        print(row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 1, rowOrColumnNumber: i, start : 5)
        }
    }


    func checkDiagonal2(){
        var sameColor = 0

        copyRowToTemp()

        row2Temp = insertInRow(antal: 1, rad: row2Temp)
        row3Temp = insertInRow(antal: 2, rad: row3Temp)
        row4Temp = insertInRow(antal: 3, rad: row4Temp)
        row5Temp = insertInRow(antal: 4, rad: row5Temp)
        row6Temp = insertInRow(antal: 5, rad: row6Temp)
        row7Temp = insertInRow(antal: 6, rad: row7Temp)
        row8Temp = insertInRow(antal: 7, rad: row8Temp)

        print(row1Temp)
        print(row2Temp)
        print(row3Temp)
        print(row4Temp)
        print(row5Temp)
        print(row6Temp)
        print(row7Temp)
        print(row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 2, rowOrColumnNumber: i, start : 1)
        }

        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)

        row3Temp = insertInRow(antal: 1, rad: row3Temp)
        row4Temp = insertInRow(antal: 2, rad: row4Temp)
        row5Temp = insertInRow(antal: 3, rad: row5Temp)
        row6Temp = insertInRow(antal: 4, rad: row6Temp)
        row7Temp = insertInRow(antal: 5, rad: row7Temp)
        row8Temp = insertInRow(antal: 6, rad: row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 2, rowOrColumnNumber: i, start : 2)
        }

        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)

        row4Temp = insertInRow(antal: 1, rad: row4Temp)
        row5Temp = insertInRow(antal: 2, rad: row5Temp)
        row6Temp = insertInRow(antal: 3, rad: row6Temp)
        row7Temp = insertInRow(antal: 4, rad: row7Temp)
        row8Temp = insertInRow(antal: 5, rad: row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 2, rowOrColumnNumber: i, start : 3)
        }

        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)
        row3Temp = Array(repeating: 0, count: 17)

        row5Temp = insertInRow(antal: 1, rad: row5Temp)
        row6Temp = insertInRow(antal: 2, rad: row6Temp)
        row7Temp = insertInRow(antal: 3, rad: row7Temp)
        row8Temp = insertInRow(antal: 4, rad: row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 2, rowOrColumnNumber: i, start : 4)
        }

        copyRowToTemp()

        row1Temp = Array(repeating: 0, count: 17)
        row2Temp = Array(repeating: 0, count: 17)
        row3Temp = Array(repeating: 0, count: 17)
        row4Temp = Array(repeating: 0, count: 17)
        row6Temp = insertInRow(antal: 1, rad: row6Temp)
        row7Temp = insertInRow(antal: 2, rad: row7Temp)
        row8Temp = insertInRow(antal: 3, rad: row8Temp)

        for i in 1...8{
            testDiagonal(rad: column1Temp, column: i, diagonalOneOrTwo: 2, rowOrColumnNumber: i, start : 5)
        }
    }

    func checkRows(){
        print("------rows------")
        for i in 1...8{
            test(rad: arrayOfRows[i], column: 0, copyRowToColumn:false, rowOrColumnNumber:i)
        }
    }

    func checkColumns()
    {
        print("------columns------")
        for i in 1...8{
            test(rad: arrayOfColumns[i], column: 9, copyRowToColumn:false, rowOrColumnNumber:i)
        }
    }

    func testDiagonal(rad: [Int], column: Int, diagonalOneOrTwo: Int, rowOrColumnNumber : Int, start : Int){
        var inRowRed = 0
        var inRowGreen = 0
        var rad2:[Int] = rad
        var firstGreenInColumn = 0
        var firstRedInColumn = 0
        var firstMark = 0
        var Hole = 0
        var Rest = 0

        copyRowToColumn2(i: column)
        rad2 = column1Temp

        print("här har vi columntemp \(column1Temp)")
  //      print("Rad \(rad2)")
            for i in 1...8{
                if (rad2[i] == 1){
                    firstRedInColumn = 0
                    if (firstGreenInColumn == 0){
                        firstGreenInColumn = i
                    }
                    inRowGreen += 1

                    if (inRowGreen >= checkForNumbers){
                        print("firstGreenInColumn: \(firstGreenInColumn)")
                        print("i: \(i)")

                        winner(color:"Grön", column: column)
                    }
                }
                else{
                    inRowGreen = 0
                }
                if (rad2[i] == 2){
                    firstGreenInColumn = 0
                    if (firstRedInColumn == 0){
                        firstRedInColumn = i
                    }
                    inRowRed += 1
                   // if (inRowRed > 3){
                    if (inRowRed >= checkForNumbers){
                        print("firstRedInColumn: \(firstRedInColumn)")
                        print("i: \(i)")

                        winner(color:"Röd", column: column)
                    }
                }
                else{
                    inRowRed = 0
                }
        }
    }


    func test(rad: [Int], column: Int, copyRowToColumn: Bool, rowOrColumnNumber : Int){
        var inRowRed = 0
        var inRowGreen = 0
        var rad2:[Int] = rad
        var firstInRow = 0

        print("-------test rad-----")
        print(rad)

        if (copyRowToColumn == true){
            copyRowToColumn2(i: column)
            rad2 = column1Temp
            for i in 1...8{
                if (rad2[i] == 1){

                    inRowGreen += 1

                    if (inRowGreen >= checkForNumbers){
                        winner(color:"Grön", column: column)
                    }
                }
                else{
                    inRowGreen = 0
                }
                if (rad2[i] == 2){

                    inRowRed += 1

                    if (inRowRed >= checkForNumbers){
                        winner(color:"Röd", column: column)
                    }
                }
                else{
                    inRowRed = 0
                }
            }
        }else{
        // Check row and check column will enter here
            // When I check rows then Column enters as value 0, when I check column the Column enters as value 9
        for i in 1...8{

            if (inRowRed == 1){
                firstInRow = i
            }
            if (inRowGreen == 1){
                firstInRow = i
            }

            if (rad[i] == 1){

                inRowGreen += 1

                if (inRowGreen >= checkForNumbers){
                    print("First \(firstInRow-1)")
                    print("Last \(i)")

                    winner(color:"Grön", column: column)
                }
            }
            else{
                inRowGreen = 0
            }
            if (rad[i] == 2){

                inRowRed += 1

                if (inRowRed >= checkForNumbers){
                    print("First \(firstInRow-1)")
                    print("Last \(i)")

                    winner(color:"Röd", column: column)
                }
            }
            else{
                inRowRed = 0
            }
        }
        }
    }



    func winner(color:String, column: Int){
        print("Vinnare är \(color). \(color) har fått fyra i rad")

        if (checkForNumbers == 4){
            if (color == "Grön"){
                playSound(fileName: "grönfyra1")
            }
            else{
                playSound(fileName: "rödfyra1")
            }
            andTheWinnerIs.text = "Vinnare är \(color). \(color) har fått fyra i rad."
        }
        else{
            if (color == "Grön"){
                playSound(fileName: "grönfem1")
            }
            else{
                playSound(fileName: "rödfem1")
            }
            andTheWinnerIs.text = "Vinnare är \(color). \(color) har fått fem i rad."
        }
        theWinningColor.isEnabled = true
        theWinningColor.alpha = 1
        andTheWinnerIs.backgroundColor = .systemPurple
        if (color == "Grön")
        {
            theWinningColor.backgroundColor = .green
        }
        else
        {
            theWinningColor.backgroundColor = .red
        }
    }
}



 */