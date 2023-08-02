# Untitled

此项目用于 AutoCRUD 测试： https://github.com/unit-mesh/autocrud ，没有必要 fork>


## 用户故事示例

### OKR

用户故事：更新 OKR 进度
作为一个员工
我想要在 OKR 系统中更新我的 OKR 进展情况
以便于保持团队的透明度和协同性，并向团队报告我的进展情况

AC 1: 更新单个 OKR 的进度
Given 我已经登录到 OKR 系统并且有正在进行的 OKR
When 我为某个 OKR 输入新的进度信息
Then 系统应该保存并展示更新后的进度信息

AC 2: 一次更新多个 OKR 的进度
Given 我已经登录到 OKR 系统并且有多个正在进行的 OKR
When 我为多个 OKR 同时输入新的进度信息
Then 系统应该保存并展示所有更新后的进度信息

AC 3: 更新进度时添加备注
Given 我已经登录到 OKR 系统并且有正在进行的 OKR
When 我为某个 OKR 输入新的进度信息，并添加备注说明
Then 系统应该保存并展示更新后的进度信息以及备注

AC 4: 查看 OKR 更新历史
Given 我已经登录到 OKR 系统并且有正在进行的 OKR
When 我查看某个 OKR 的更新历史
Then 系统应该展示该 OKR 的所有更新记录，包括更新时间、进度和备注

AC 5: 更新进度时出现错误提示
Given 我已经登录到 OKR 系统并且有正在进行的 OKR
When 我为某个 OKR 输入错误的进度信息（如负数或超过 100%）
Then 系统应该提示我输入的进度信息有误，并要求我重新输入正确的进度信息
