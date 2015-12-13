package frame;

import input.MouseInteractiveListener;

import javax.swing.JOptionPane;

import main.Main;
import render.RendableHolder;
import render.RenderHelper;
import render.rendable.StaticImageRendable;
import base.GameScreen;
import base.GameState;
import base.ZIndex;

public class MenuFrame implements Frame {
	public MenuFrame() {
		StaticImageRendable bg = new StaticImageRendable("menu_bg");
		float ratio = Math.max((float) GameScreen.WIDTH / bg.getWidth(), (float) GameScreen.HEIGHT / bg.getHeight());
		
		ratio = 1;
		
		bg.setPos(GameScreen.WIDTH / 2, GameScreen.HEIGHT / 2);
		bg.setAlign(RenderHelper.CENTER_MIDDLE);
		bg.setRatio(ratio);
		bg.setZ(ZIndex.BACKGROUND);
		
		RendableHolder.add(bg);
		
		String[] btnName = {"start_btn", "highscore_btn", "exit_btn"};
		
		for(int i=0; i<btnName.length; i++) {
			StaticImageRendable btn = new StaticImageRendable(btnName[i], GameScreen.WIDTH / 2, GameScreen.HEIGHT - 300 + i * 100, 1f);
			
			String currentBtnName = btnName[i];
			
			btn.setAlign(RenderHelper.CENTER_MIDDLE);
			btn.setZ(ZIndex.MENU_BTN);
			btn.addMouseInteractiveListener(new MouseInteractiveListener<StaticImageRendable>() {
				
				@Override
				public void onLeave(StaticImageRendable btn) {
					btn.setHoverEffect(false);
				}
				
				@Override
				public void onEnter(StaticImageRendable btn) {
					btn.setHoverEffect(true);
				}
				
				@Override
				public void onClick(StaticImageRendable btn) {
					if(currentBtnName.equals("start_btn")) {
						GameState.getInstance().changeStage(GameState.GAME_STAGE);
					} else if(currentBtnName.equals("exit_btn")) {
						int dialogResult = JOptionPane.showConfirmDialog(
							Main.getFrame(), 
							"Wold you like to exit the game ?",
							"Warning",
							JOptionPane.YES_NO_OPTION
						);
						
						if(dialogResult == JOptionPane.YES_OPTION) {
							System.exit(0);
						}
					}
				}
			});
			RendableHolder.add(btn);
		}
		
		StaticImageRendable logo = new StaticImageRendable("logo", GameScreen.WIDTH / 2, 250, 1f);
		logo.setAlign(RenderHelper.CENTER_MIDDLE);
		logo.setZ(ZIndex.MENU_BTN);
		RendableHolder.add(logo);
	}

	@Override
	public void update() {}

	@Override
	public void pause() {}

	@Override
	public void destroy() {}
}