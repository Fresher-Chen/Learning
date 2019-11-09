# Learning
`Notes`
* Git cmd（撤销修改）
  * 修改加入过暂存区
  ```Bash
  git reset --hard
  git clean -xdf
  ```
  * 没有加入暂存区
  ```Bash
  git checkout . && git clean -xdf
  ```
