package org.sudoku.model;

public class Cell
{
   private int rowIndex;
   private int columnIndex;
   private int value;
   private Row row;
   private Column column;

   public Cell(int rowIndex, int columnIndex, int value)
   {
      this.rowIndex = rowIndex;
      this.columnIndex = columnIndex;
      this.value = value;
   }

   public int getValue()
   {
      return value;
   }

   @Override
   public String toString()
   {
      return String.valueOf(value);
   }

   public int getRowIndex()
   {
      return rowIndex;
   }

   public int getColumnIndex()
   {
      return columnIndex;
   }

   public void link(Row row)
   {
      this.row = row;
   }

   public void link(Column column)
   {
      this.column = column;
   }
}
