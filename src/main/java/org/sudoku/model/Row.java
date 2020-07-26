package org.sudoku.model;

import java.util.ArrayList;
import java.util.List;

public class Row
{
   private List<Cell> cells;
   private int size;

   public Row(int size)
   {
      this.size = size;
      this.cells = new ArrayList<>(size);
   }

   public void addCell(Cell cell)
   {
      cell.link(this);
      cells.add(cell);
   }
}
