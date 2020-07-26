package org.sudoku.model;

public class CellReference
{
   private Cell cell;
   private Cell[] boxCells;
   private Cell[] rowCells;
   private Cell[] columnCells;
   private int fillCount;

   public CellReference(Cell cell, Cell[] boxCells, Cell[] rowCells, Cell[] columnCells)
   {
      this.cell = cell;
      this.boxCells = boxCells;
      this.rowCells = rowCells;
      this.columnCells = columnCells;
      fillCount = boxCells.length + columnCells.length + rowCells.length;
   }

}
