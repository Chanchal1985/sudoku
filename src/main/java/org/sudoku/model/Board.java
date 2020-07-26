package org.sudoku.model;

public class Board
{
   private Cell[][] cells;
   private Row[] rows;
   private Column[] columns;
   private Box[] boxes;
   private int size;

   private Board(int size, Cell[][] cells)
   {
      this.size = size;
      this.cells = cells;
      rows = new Row[size];
      rows = initializeRows(cells);
      columns = initializeColumns(cells);
   }

   private Column[] initializeColumns(Cell[][] cells)
   {

      Column[] cols = new Column[cells.length];
      for (int counter = 0; counter < cells.length; counter++)
      {
         Cell[] colCells = cells[cells.length];
         for (int temp = 0 ;temp < cells.length ; temp++)
         {
            colCells[temp] = cells[temp][counter];
         }
         cols[counter] = new Column(colCells);
      }
      return cols;
   }

   private Row[] initializeRows(Cell[][] cells)
   {
      Row[] rows = new Row[cells.length];
      for (int counter = 0; counter < cells.length; counter++)
      {
         Cell[] rowCells = cells[cells.length];
         for (int temp = 0 ;temp < cells.length ; temp++)
         {
            rowCells[temp] = cells[counter][temp];
         }
         rows[counter] =  new Row(rowCells);
      }
      return rows;
   }

   public static class Builder
   {
      private Cell[][] cells;
      private int size;

      public Builder(int size)
      {
         this.size = size;
         this.cells = new Cell[size][size];
      }

      public Builder withValue(int rowIndex, int colIndex, int value)
      {
         if (rowIndex >= size || colIndex >= size)
         {
            throw new IllegalArgumentException(String.format("rowIndex %s or colIndex %s can not exceed size %s ", rowIndex, colIndex, size));
         }
         cells[rowIndex][colIndex] = new Cell(value);
         return this;
      }

      public Board build()
      {
         return new Board(size, cells);
      }
   }
}
