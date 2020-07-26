package org.sudoku.main;

import org.sudoku.model.Board;

public class SudokuRunner
{
   public static void main(String[] args)
   {
      Board board  = new Board
                        .Builder(3)
                        .withValue(0,0,1)
                        .build();
      board.print();

   }
}
