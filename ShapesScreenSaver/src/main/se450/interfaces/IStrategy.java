package main.se450.interfaces;

import main.se450.collections.Septuplet;

public interface IStrategy 
{
	Septuplet<?,?,?,?,?,?,?> execute(float left, float top, float right, float bottom, float x, float y, int color);
}
      