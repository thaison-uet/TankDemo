package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Executable;
import java.util.BitSet;

import javax.swing.ImageIcon;

import model.DynamicObject;
import model.GameManager;
import model.MyTank;

public class GameContainer extends BaseContainer implements Runnable
{
    private Thread thread;
    private GameManager gameManager;
    private BitSet bitSet;

    public GameContainer(int width, int height)
    {
        super(width, height);
    }

    @Override
    protected void initPanel()
    {
        setSize(this.width, this.height);
        setBackground(Color.PINK);
    }

    @Override
    protected void initComponents()
    {
        gameManager = new GameManager();
        bitSet = new BitSet(5);
        KeyAdapter keyAdapter = new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                execuseKeyListener(e, true);
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                execuseKeyListener(e, false);
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void addComponents()
    {

    }

    private void execuseKeyListener(KeyEvent e, boolean isPressed)
    {
        int code = e.getKeyCode();
        switch (code)
        {
            case KeyEvent.VK_LEFT:
                bitSet.set(DynamicObject.LEFT, isPressed);
                break;
            case KeyEvent.VK_UP:
                bitSet.set(DynamicObject.UP, isPressed);
                break;
            case KeyEvent.VK_RIGHT:
                bitSet.set(DynamicObject.RIGHT, isPressed);
                break;
            case KeyEvent.VK_DOWN:
                bitSet.set(DynamicObject.DOWN, isPressed);
                break;
            case KeyEvent.VK_SPACE:
                bitSet.set(DynamicObject.BULLET, isPressed);
            default:
                break;
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        gameManager.drawTank(g2d);
        gameManager.drawBulletTank(g2d);
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (bitSet.get(DynamicObject.LEFT))
            {
                gameManager.setMyTankOrientation(DynamicObject.LEFT);
                gameManager.moveMyTank();
            } else if (bitSet.get(DynamicObject.RIGHT))
            {
                gameManager.setMyTankOrientation(DynamicObject.RIGHT);
                gameManager.moveMyTank();
            } else if (bitSet.get(DynamicObject.UP))
            {
                gameManager.setMyTankOrientation(DynamicObject.UP);
                gameManager.moveMyTank();
            } else if (bitSet.get(DynamicObject.DOWN))
            {
                gameManager.setMyTankOrientation(DynamicObject.DOWN);
                gameManager.moveMyTank();
            }
            if (bitSet.get(DynamicObject.BULLET))
            {
                gameManager.fireMyTank();
            }
            gameManager.moveAllBulletOfMyTank();
            repaint();
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }


}
