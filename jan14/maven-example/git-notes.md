## git and github

git is a Version Control program that tracks differences between files within a repository.
A Repository is a particular directory that git is collecting and tracking.

github is a remote repository that you can commit your local repository to.
This allows for multiple people to work on an ever-changing repo.
It also has useful features for issue tracking and CI workflows with things like github Actions.

### Basic git Commands

 - `git init`
  - Starts a new repository
 - `git add` <files>
  - Adds changes within these files to the next commit.
 - `git commit -m` <message>
  - Saves the changes that were added to the branch history.
 - `git push` <remote> <branch>
  - Transfers the commits from your local repo to the remote repository
 - `git pull` <upstream> <branch>
  - Updates your local repository with the updates from the remote repo.
 - `git checkout` <branch>
  - Changes the current branch you're working on.
 - `git merge` <branch>
  - Merges the branch specified into your current branch.

+ Plenty more! See more [here](https://git-scm.com/book/en/v2)!