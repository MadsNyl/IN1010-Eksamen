import random
import pygame as pg
import sys
pg.init()
pg.font.init()

class Box:
    def __init__(self, screen, row, column, isOpen):
        self.screen = screen
        self.row = row
        self.column = column
        self.isOpen = isOpen
        self.rect = pg.Rect(self.column * size, self.row * size, size, size)
    
    def draw(self):
        if self.isOpen: 
            pg.draw.rect(self.screen, (255, 255, 255), self.rect, 1)
        else:
            pg.draw.rect(self.screen, (255, 0, 0), self.rect)

    def collide(self, pos):
        return self.rect.collidepoint(pos)

    def checkIfOpen(self):
        return self.isOpen
    
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
        pg.draw.rect(self.screen, (255, 255, 255), self.rect, 1)
        text = FONT.render(self.text, False, (255, 255, 255))
        screen.blit(text, (self.x + (self.width / 4), self.y + (self.height / 4)))
    
    def collide(self, pos):
        return self.rect.collidepoint(pos)

def setupGrid():
    for row in range(rows):
        grid_row = []
        for col in range(columns):
            grid_row.append(Box(screen, row, col, True))
        grid.append(grid_row)

def restartGrid():
    grid = []
    for row in range(rows):
        grid_row = []
        for col in range(columns):
            grid_row.append(Box(screen, row, col, True))
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
        file = open(f"Maps/map{random.randint(0, 1000)}.txt", "a")
        file.write(f"{rows} {columns}\n")
        for row in range(rows):
            line = ""
            for col in range(columns):
                if grid[row][col].checkIfOpen():
                    line += "."
                else:
                    line += "x"
            file.write(line + "\n")
        file.close()




WIDTH = 1200
HEIGHT = 400
rows = 20
columns = 40
size = 20
FONT = pg.font.SysFont("Sans Serif", 20)

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
            kjor = False
            sys.exit()
        if event.type == pg.MOUSEBUTTONDOWN:
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
    
    pg.display.update()
    clock.tick(60)

pg.quit()