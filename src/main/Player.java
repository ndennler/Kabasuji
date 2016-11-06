package main;

import java.util.ArrayList;

import general.boundary.PlayerMenu;
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

public class Player {

	public static void main(String[] args) {

		Kabasuji k = new Kabasuji();
		
		ArrayList<ILevelGUI> lguis = new ArrayList<ILevelGUI>();
		lguis.add(new PuzzleLevelGUI(new PuzzleLevel(), k));
		lguis.add(new ReleaseLevelGUI(new ReleaseLevel(), k));
		lguis.add(new LightningLevelGUI(new LightningLevel(), k));
		lguis.add(new CoverUpLevelGUI(new CoverUpLevel(), k));

		ArrayList<IBuilderGUI> bguis= new ArrayList<IBuilderGUI>();
		bguis.add(new PuzzleBuilderGUI(new PuzzleLevel(), new DennlerStock(), k));
		bguis.add(new ReleaseBuilderGUI(new ReleaseLevel(), new DennlerStock(), k));
		bguis.add(new LightningBuilderGUI(new LightningLevel(), new DennlerStock(), k));
		bguis.add(new CoverUpBuilderGUI(new CoverUpLevel(), new DennlerStock(), k));
		
		Loader l = new Loader();
		int i = 1;
		ArrayList<ILevel> levels = new ArrayList<ILevel>();
		while(l.getLevel(i) != null){
			for(ILevelGUI gui : lguis){
				if(l.getLevel(i).getType().equals(gui.getLevelType())){
					ILevel level = gui.getGenericLevel();
					level.restore(l.getLevel(i));
					levels.add(level);
				}
			}
			i++;
		}


		k = new Kabasuji(levels, bguis, lguis);

		PlayerMenu pm = new PlayerMenu(k);
		pm.setVisible(true);
	}
}
