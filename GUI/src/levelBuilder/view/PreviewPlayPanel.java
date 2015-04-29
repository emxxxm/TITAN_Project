package levelBuilder.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import levelBuilder.entity.BonusFrequency;
import levelBuilder.entity.Model;
import levelBuilder.entity.NumFrequency;
import levelBuilder.entity.Position;

public class PreviewPlayPanel extends JPanel {
	Model model;

	public PreviewPlayPanel(Model m) {
		this.model = m;
	}

	public int determineNum(double freq) {
		int num = 0;
		NumFrequency numFreq = model.getNumFrequency();
		double bound2 = numFreq.getFre1() + numFreq.getFre2();
		double bound3 = bound2 + numFreq.getFre3();
		double bound4 = bound3 + numFreq.getFre4();
		double bound5 = bound4 + numFreq.getFre5();

		if (freq < numFreq.getFre1()) {
			num = 1;
		} else if (numFreq.getFre1() < freq && freq < bound2) {
			num = 2;
		} else if (bound2 < freq && freq < bound3) {
			num = 3;
		} else if (bound3 < freq && freq < bound4) {
			num = 4;
		} else if (bound4 < freq && freq < bound5) {
			num = 5;
		} else if (freq > bound5) {
			num = 6;
		}
		return num;
	}

	public int determineMulti(double freq) {
		int num = 0;
		BonusFrequency bonusFreq = model.getBonusFrequency();

		if (freq < bonusFreq.getx2()) {
			num = 2;
		} else if (bonusFreq.getx2() < freq
				&& freq < bonusFreq.getx2() + bonusFreq.getx3()) {
			num = 3;
		}

		return num;
	}

	public Color setSquareColor(int num) {
		// Put the things above in Tile.
		Color color = null;
		switch (num) {
		case 1:
			color = new Color(192, 80, 77);
			break;
		case 2:
			color = new Color(155, 187, 89);
			break;
		case 3:
			color = new Color(254, 0, 133);
			break;
		case 4:
			color = new Color(247, 150, 70);
			break;
		case 5:
			color = new Color(128, 100, 162);
			break;
		case 6:
			color = new Color(75, 172, 198);
			break;
		}
		return color;

	}

	@Override
	protected void paintComponent(Graphics graph) {
		super.paintComponent(graph);
		// Use 0, 1, 2 to represent disable, enable and bucket.

		// DisableSquareList disabled=model.getDisableSquareList();
		// BucketList bucket=model.getBucket();
		// SixList six=model.getSix();
		int[] squares = new int[81];
		Arrays.fill(squares, 1);

		ArrayList<Position> disabled = model.getDisableSquareList()
				.getDisableSquareList();
		ArrayList<Position> bucket = model.getBucket().getBucketList();
		ArrayList<Position> six = model.getSix().getSixList();

		for (Position disabledSqr : disabled) {
			int x = disabledSqr.getRow();
			int y = disabledSqr.getCol();
			//graph.setColor(Color.white);
			graph.drawRect(57 + y* 47, 7 + x * 47, 40, 40);
			graph.fillRect(57 + y* 47, 7 + x * 47, 40, 40);
			if (9 * x + y >= 0) {
				squares[9 * x + y] = 0;
			}
		}
		for (Position bucketSqr : bucket) {
			graph.setColor(Color.red);
			int x = bucketSqr.getRow();
			int y = bucketSqr.getCol();
			
			graph.drawRect(57 + y* 47, 7 + x * 47, 40, 40);
			graph.fillRect(57 + y* 47, 7 + x * 47, 40, 40);
			if (9 * x + y >= 0) {
				squares[9 * x + y] = 0;
			}
		}
		for (Position sixSqr : six) {
			int x = sixSqr.getRow();
			int y = sixSqr.getCol();
			graph.setColor(Color.yellow);
			graph.drawRect(57 + y* 47, 7 + x * 47, 40, 40);
			graph.fillRect(57 + y* 47, 7 + x * 47, 40, 40);
			if (9 * x + y >= 0) {
				squares[9 * x + y] = 0;
			}
		}

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				// If this is a normal square.
				if (squares[row * 9 + col] == 1) {
					double freq = Math.random();

					int squareNum = determineNum(freq);

					graph.drawRect(57 + col * 47, 7 + row * 47, 40, 40);
					graph.setColor(setSquareColor(squareNum));
					graph.fillRect(57 + col * 47, 7 + row * 47, 40, 40);
					graph.setColor(Color.white);
					graph.drawString(Integer.toString(squareNum), (int) (57
							+ col * 47 + 57 + col * 47 + 40) / 2, (int) (7
							+ row * 47 + 7 + row * 47 + 40) / 2);
					int squareMulti = determineMulti(freq);
					if (squareMulti != 0) {
						graph.drawString(
								"X" + (Integer.toString(squareMulti)),
								(int) (57 + col * 47 + 57 + col * 47 + 40) / 2 + 5,
								(int) (7 + row * 47 + 7 + row * 47 + 40) / 2 + 18);
					}
				}
			}

		}
	}
}
