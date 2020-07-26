package org.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class Column
{
   private List<Cell> cells;

   private int size;

   public Column(int size)
   {
      this.size = size;
      this.cells = new ArrayList<>(size);
   }

   public void addCell(Cell cell)
   {
      if (cells.size() >= size)
      {
         throw new ArrayIndexOutOfBoundsException(String.format("Column is already full size %s", cells.size()));
      }
      cell.link(this);
      cells.add(cell);
   }
}
