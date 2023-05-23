import random
import pygame as pg
import sys
import os
pg.init()
pg.font.init()

class Box:
    def __init__(self, screen, row, column, isOpen, isEnemy):
        self.screen = screen
        self.row = row
        self.column = column
        self.isOpen = isOpen
        self.isEnemy = isEnemy
        self.rect = pg.Rect(self.column * size, self.row * size, size, size)
    
    def draw(self):
        if self.isOpen: 
            pg.draw.rect(self.screen, (255, 255, 255), self.rect, 1)
        elif self.isEnemy:
            pg.draw.rect(self.screen, (255, 255, 0), self.rect)
        else:
            pg.draw.rect(self.screen, (255, 0, 0), self.rect)

    def collide(self, pos):
        return self.rect.collidepoint(pos)

    def checkIfOpen(self):
        return self.isOpen
    
    def checkIfEnemy(self):
        return self.isEnemy
    
    def changeState(self):
        self.isOpen = not self.isOpen

class Button:
    def __init__(self, screen, x, y, width, height, text):
        self.screen = screen
        self.text = text
        self.x = x
        self.y = y
        self.width = width
        self.height = height
        self.rect = pg.Rect(x, y, width, height)
    
    def draw(self):
        font = pg.font.SysFont(FONT, self.width // 4 )
        pg.draw.rect(self.screen, (255, 255, 255), self.rect)
        text = font.render(self.text, False, (0, 0, 0))
        screen.blit(text, (self.x + (self.width / 4), self.y + (self.height / 4)))
    
    def collide(self, pos):
        return self.rect.collidepoint(pos)

def setupGrid():
    for row in range(rows):
        grid_row = []
        for col in range(columns):
            if (row == 0 or row == rows - 1 or col == 0 or col == columns - 1):
                grid_row.append(Box(screen, row, col, False, False))
            else:
                grid_row.append(Box(screen, row, col, True, False))
        grid.append(grid_row)

def restartGrid():
    grid = []
    for row in range(rows):
        grid_row = []
        for col in range(columns):
            if (row == 0 or row == rows - 1 or col == 0 or col == columns - 1):
                grid_row.append(Box(screen, row, col, False, False))
            else:
                grid_row.append(Box(screen, row, col, True, False))
        grid.append(grid_row)
    return grid

def drawButtons():
    small_grid.draw()
    medium_grid.draw()
    large_grid.draw()
    create_map.draw()

def drawGrid():
    for x in range(rows):
        for y in range(columns):
            grid[x][y].draw()

def boxHit():
    for row in range(rows):
        for col in range(columns):
            if grid[row][col].collide(pg.mouse.get_pos()):
                grid[row][col].changeState()

def createMap():
    if create_map.collide(pg.mouse.get_pos()):
        maps = os.listdir("Maps")
        count = 0
        if (len(maps) > 0):
            last_map = maps[len(maps) - 1][-5]
            count = int(last_map) + 1
        file = open(f"Maps/map{count}.txt", "a")
        file.write(f"{rows} {columns}\n")
        for row in range(rows):
            line = ""
            for col in range(columns):
                if grid[row][col].checkIfOpen():
                    line += "."
                elif grid[row][col].checkIfEnemy():
                    line += "e"
                else:
                    line += "x"
            file.write(line + "\n")
        file.close()

def setEnemy():
    for row in range(rows):
        for col in range(columns):
            if grid[row][col].collide(pg.mouse.get_pos()):
                grid[row][col] = Box(screen, row, col, False, True)




WIDTH = 1200
HEIGHT = 400
rows = 20
columns = 40
size = 20
FONT = "Sans Serif"

screen = pg.display.set_mode([WIDTH, HEIGHT])
clock = pg.time.Clock()



grid = []

setupGrid()
small_grid = Button(screen, 900, 100, 60, 20, "10x20")
medium_grid = Button(screen, 1000, 100, 60, 20, "15x30")
large_grid = Button(screen, 1100, 100, 60, 20, "20x40")
create_map = Button(screen, 1000, 300, 120, 40, "CREATE")

run = True
while run:
    screen.fill((0,0,0))
    drawGrid()
    drawButtons()

    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False
            sys.exit()
        if event.type == pg.MOUSEBUTTONDOWN and event.button == 1:
            boxHit()
            createMap()
            if small_grid.collide(pg.mouse.get_pos()):
                rows = 10
                columns = 20
                size = 40
                grid = restartGrid()

            if medium_grid.collide(pg.mouse.get_pos()):
                rows = 15
                columns = 30
                size = 25
                grid = restartGrid()

            if large_grid.collide(pg.mouse.get_pos()):
                rows = 20
                columns = 40
                size = 20
                grid = restartGrid()
        if event.type == pg.MOUSEBUTTONDOWN and event.button == 3:
            setEnemy()
    
    pg.display.update()
    clock.tick(60)

pg.quit()