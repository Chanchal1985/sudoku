package org.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class Board
{
   private Cell[][] cells;
   private List<Row> rows;
   private List<Column> columns;
   private List<Box> boxes;
   private int size;

   private Board(int size, Cell[][] cells)
   {
      this.size = size;
      this.cells = cells;
      rows = initializeRows(size);
      columns = initializeColumns(size);
   }

   private List<Column> initializeColumns(int size)
   {

      List<Column> columns = new ArrayList<>(size);

      for (int counter = 0; counter < size; counter++)
      {
         columns.add(new Column(counter));
      }
      return columns;
   }

   private void initializeCells(Cell[][] cells)
   {
      for (int counter = 0; counter < cells.length; counter++)
      {
         for (int temp = 0; temp < cells.length; temp++)
         {
            Cell cell = cells[temp][counter];
            rows.get(counter).addCell(cell);
            columns.get(temp).addCell(cell);
         }
      }
   }

   private List<Row> initializeRows(int size)
   {
      List<Row> rows = new ArrayList<>(size);

      for (int counter = 0; counter < size; counter++)
      {
         rows.add(new Row(counter));
      }
      return rows;
   }

   public static class Builder
   {
      private Cell[][] cells;
      private int size;

      public Builder(int size)
      {
         // TODO : fix the sqrt for integer
         if (Math.sqrt(size) < 0)
         {
            throw new IllegalArgumentException(String.format("Invalid size %s, Please enter a number which can have a square root", size));
         }
         this.size = size;
         this.cells = initialize(size);
      }

      private Cell[][] initialize(int size)
      {
         Cell[][] tempcells = new Cell[size][size];
         for (int i = 0; i < size; i++)
         {
            for (int j = 0; j < size; j++)
            {

               tempcells[i][j] = new Cell(i, j, 0);
            }
         }
         return tempcells;
      }

      public Builder withValue(int rowIndex, int colIndex, int value)
      {
         checkSize(rowIndex, colIndex);

         checkValue(value);

         cells[rowIndex][colIndex] = new Cell(rowIndex, colIndex, value);
         return this;
      }

      private void checkValue(int value)
      {
         if (value == 0 || value > size)
         {
            throw new IllegalArgumentException(String.format("value %s can not exceed size %s ", value, size));
         }
      }

      private void checkSize(int rowIndex, int colIndex)
      {
         if (rowIndex >= size || colIndex >= size)
         {
            throw new IllegalArgumentException(String.format("rowIndex %s or colIndex %s can not exceed size %s ", rowIndex, colIndex, size));
         }
      }

      public Board build()
      {
         return new Board(size, cells);
      }
   }

   public void print()
   {
      for (int i = 0; i < size; i++)
      {
         for (int j = 0; j < size; j++)
         {
            System.out.print(cells[i][j]);
            System.out.print("\t");
         }
         System.out.println();
      }
   }

   public List<CellReference> arrange()
   {
      List<CellReference> cellReferences = new ArrayList<>();

      for (int i = 0; i < size; i++)
      {
         for (int j = 0; j < size; j++)
         {
            Cell cell = cells[i][j];
            CellReference reference = new CellReference(cell,);
         }
         System.out.println();
      }

      return cellReferences;
   }
}
