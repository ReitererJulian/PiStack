# Git cheat sheet

---

## Important commands:


### Initialize repository

```bash
git init
```


### Clone repository

```bash
git clone <url>
```


### Add files

```bash
git add file.txt

git add .       # add all files
```


### Commit files

```bash
git commit -m "Commit message"
```


### See status

```bash
git status
```


### Show commit history

```bash
git log
```


### Add remote repository

```bash
git remote add origin <url>
```


### Push changes

```bash
git push origin <branch>
```


### Get changes

```bash
git pull

git pull origin <branch> 
```


### Create new branch

```bash
git branch <branch>
```

### Change branch

```bash
git checkout <branch>
```

### Merge branches

```bash
git merge <branch>
```


### Discard changes

```bash
git checkout --file.txt
```


---

## How to commit message

Message needs to show what the commit does, not what the developer changed
Using the Present

### Great examples

```bash
git commit -m "Fix login bug"
```

```bash
git commit -m "Add user authentication"
```