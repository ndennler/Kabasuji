package main;

import java.util.ArrayList;

import general.boundary.BuilderMenu;
import general.entity.DennlerStock;
import general.entity.Kabasuji;
import general.entity.Loader;
import interfaces.IBuilderGUI;
import interfaces.ILevel;
import interfaces.ILevelGUI;
import lightning.LightningBuilderGUI;
import lightning.LightningLevel;
import lightning.LightningLevelGUI;
import puzzle.PuzzleBuilderGUI;
import puzzle.PuzzleLevel;
import puzzle.PuzzleLevelGUI;
import release.ReleaseBuilderGUI;
import release.ReleaseLevel;
import release.ReleaseLevelGUI;
import twoAndaHalfCoverUp.CoverUpBuilderGUI;
import twoAndaHalfCoverUp.CoverUpLevel;
import twoAndaHalfCoverUp.CoverUpLevelGUI;

public class Builder {

	public static void main(String[] args) {

		Kabasuji k = new Kabasuji();
		
		ArrayList<IBuilderGUI> bguis= new ArrayList<IBuilderGUI>();
		bguis.add(new PuzzleBuilderGUI(new PuzzleLevel(), new DennlerStock(), k));
		bguis.add(new ReleaseBuilderGUI(new ReleaseLevel(), new DennlerStock(), k));
		bguis.add(new LightningBuilderGUI(new LightningLevel(), new DennlerStock(), k));
		bguis.add(new CoverUpBuilderGUI(new CoverUpLevel(), new DennlerStock(), k));

		
		ArrayList<ILevelGUI> lguis = new ArrayList<ILevelGUI>();
		lguis.add(new PuzzleLevelGUI(new PuzzleLevel(), k));
		lguis.add(new ReleaseLevelGUI(new ReleaseLevel(), k));
		lguis.add(new LightningLevelGUI(new LightningLevel(), k));
		lguis.add(new CoverUpLevelGUI(new CoverUpLevel(), k));


		Loader l = new Loader();
		int i = 1;
		ArrayList<ILevel> levels = new ArrayList<ILevel>();
		while(l.getLevel(i) != null){
			if(l.getLevel(i).getType().equals("Puzzle")){
				PuzzleLevel p = new PuzzleLevel();
				p.restore(l.getLevel(i));
				levels.add(p);
			}
			if(l.getLevel(i).getType().equals("Release")){
				ReleaseLevel r = new ReleaseLevel();
				r.restore(l.getLevel(i));
				levels.add(r);
			}
			if(l.getLevel(i).getType().equals("Lightning")){
				LightningLevel r = new LightningLevel();
				r.restore(l.getLevel(i));
				levels.add(r);
			}
			if(l.getLevel(i).getType().equals("Cover Up")){
				CoverUpLevel r = new CoverUpLevel();
				r.restore(l.getLevel(i));
				levels.add(r);
			}
			i++;
		}
		
		k = new Kabasuji(levels, bguis, lguis);
		
		BuilderMenu bm = new BuilderMenu(k);
		bm.setVisible(true);
	}

}
