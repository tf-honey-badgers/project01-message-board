# Git 기초

## 처음 설정하기
프로그램 설치 : SourceTree 다운로드 > BitBucket 회원가입 (실제 사용하지는 않는다) <br/>
local repo 만들기 : Clone > https://github.com/tf-honey-badgers/project01-message-board.git > local repo 저장 위치 지정 > "Clone" 클릭 <br/>
develop branch 가져오기 : SourceTree 중앙 창에서 "origin/develop" 태그가 있는 줄을 더블클릭 > checkout new branch에서 이름을 "develop"로 작성 > "OK" 클릭 <br/>
> remote repo의 develop branch를 나의 local repo로 가져온다. <br/>

개인 branch 만들기 : "Branch" 클릭 > new branch 입력란에 실제 내가 사용할 개인 branch 명 입력 > "Create Branch" 클릭 <br/>
> 사실 3번째 branch는 개인용이라기보다는 특정 주제나 기능을 구현할 때 사용하고, 작업 완료 후에는 develop branch로 merge한다. <br/>
>> remote repo에 branch 만들기 : local branch 만들고 remote repo에 push하면 remote repo에서도 만들어진다.

## GitHub에 코드 올리기
Add/Stage > Commit > Pull > Push <br/>
> Add/Stage -> Git에서 트래킹하고 있지 않는 파일을 트래킹하게 한다. <br/>
> Commit -> local repo에 저장하는 것. <br/>
>> Commit할 때는 메세지를 추가할 수 있는데 의미 있는 메세지를 추가할 것 <br/>
>>> "올라가라" 같은 것은 사용하지 말고 차라리 "테스트"라고 쓸 것 <br/>
>>> "로그인 코드 수정" 등을 사용할 것 <br/>
> Pull 후 Push -> remote repo에서의 코드가 변경되었을 가능성이 있기에 항상 먼저 가져온 후 내 코드를 올린다. <br/>

## Staging
Staging은 commit하기 전 중간 단계다.
Staging 사용하면 특정 파일만, 혹은 특정 파일의 특정 코드(줄)만 따로따로 commit할 수 있다.
> ex) index.jsp에서 10줄을 수정하고 그 중 2줄만 선택해서 commit할 수 있다.

SourceTree에서 staging할 때, 왼쪽에 staging할 파일을 선택하고 오른쪽에는 수정된 부분이 하이라이트되는데, 특정 줄을 선택하고 그 부분만 stage>commit>push할 수 있다.

## Commit
Commit은 한번에 모든 코드를 함께 올리는 것은 안 좋다. 하나의 Commit은 하나의 수정 사항만 나타내야 한다.
Spring에서 관심사의 분리 원칙이 있듯이, Commit도 비슷하게 관심사끼리 묶는다.
Commit의 목적은 이후에 다른 개발자가 봤을 때 어떤 코드를 무엇을, 어떻게, 왜 그렇게 작성/수정했는지 알 수 있게 기록을 남기고, 필요할 때 특정 버전의 코드를 찾아서 사용할 수 있게 하는 것.
> ex) 아침에 commit 후 코드 작업을 했는데 문제가 생겼다. 문제 원인도 해결도 불가능하다. 그러면 제대로 작동하던 아침 commit을 찾아내서 그 버전의 코드로 돌아간다.

## Pull
Pull은 fetch & merge을 동시수행하는 것 -> fetch (가져오고) & merge (내 것에 합친다)
Develop branch에 올리는 코드는 항상 테스트 완료한 코드일 것 -> 그래야 pull할 때 문제 없을 것을 알 수가 있다

## Revert <> Rebase <> Reset
다른 branch에서 과거 commit을 가져와 한 branch를 덮어쓴다면..... <br/>
&nbsp;&nbsp;&nbsp;&nbsp; Revert는 기록이 남는다 (여기서 옛날 버전으로 바꿨다고) <br/>
&nbsp;&nbsp;&nbsp;&nbsp; Rebase는 기록을 없앤다 (완전히 덮어쓰면서 기존 데이터를 잃는다) <br/>
> Rebase로 commit을 덮어 씌울 경우는 개인정보 등 노출해서는 안되는 정보를 공개된 repo에 올렸을 경우

&nbsp;&nbsp;&nbsp;&nbsp; Reset는 기록은 없어지지만 코드는 다시 commit할 수 있게 남는다

## 용어 정리
01. remote repository -> GitHub 본사 서버, 실제로 github.com에 접속하면 볼 수 있는 코드, 팀원이 볼려면 여기서 pull한다.
02. local repository -> 본인 컴퓨터에 위치, 본인만 볼 수 있다.
03. SourceTree 용어
> 03-A. "master" branch -> default branch, 즉시 배포 가능한 완전한 코드만 올림, 사용하지 말 것. <br/>
> 03-B. "develop" branch -> 실제로 개발할 때 사용할 branch, 팀의 코드를 합치는 곳. <br/>
> 03-C. 개인 branch -> 각 팀원이 사용할 개인 branch, 대부분의 코드는 여기로만 올릴 것. <br/>
> 03-D. "origin" -> remote repo <br/>
> 03-E. "origin/master" -> remote repo에 있는 master branch (즉, root branch) <br/>
> 03-F. "master" -> local repo의 master branch <br/>
> 03-G. "origin/HEAD" -> 기본적으로 HEAD는 가장 최신 commit(즉, 가장 최신 버전)를 가리킴. <br/>
>> (추정) origin/HEAD는 origin의 가장 최신 commit을 가리키며 clone했을 때 얻을 버전을 가리킨다. <br/>

> 03-H. "origin/develop" -> remote repo의 develop branch <br/>
> 03-I. "develop" -> local repo의 develop branch <br/>

## 기타
> Branch간 이동하면 해당 branch에 있어야할 파일 등이 자동으로 바뀐다. 파일탐색기에서도 바뀌는 것을 볼 수가 있다. 최근 branch를 변경했다면 지금이 어느 branch인지 SourceTree에서 확인하고 작업할 것! <br/>
> Branch merge는 두 개 branch를 하나로 합치는 것이 아니다! destination branch로부터 target branch로 destination branch의 모든 내용을 복붙하는 것이다. 실제로 destination branch는 살아있으며 destination branch에서 수정을 한다고 해도 target branch에 merge한 내용은 수정되지 않는다 (또다시 merge하지 않는 이상) <br/>
> 같은 파일의 같은 줄을 다르게 수정한 상황에서 merge 시 충돌난다 -> 내가 판단하여 직접 수정하거나 지시를 내려야 함. <br/>
>> ex) 출처 : git-scm.com <br/>
"<<<<<<< HEAD:index.html" <br/>
contact : email.support@github.com" <br/>
"=======" <br/>
"please contact us at support@github.com" <br/>
">>>>>>> iss53:index.html" <br/> <br/>
>>> master branch, iss53 branch에서 같은 이름의 index.html 파일의 같은 줄을 다르게 작성했다. git은 자동 merge하지 않고 일시중단하여 사용자의 수동 작업을 요구한다. <br/>

> SourceTree에서 branch만 만들면 graph에 나타나지 않는다. 그 이유는 branch를 만들어도 그 이전 branch(들)에 실제로 달라진 것은 없기 때문이다. 기존 branch에서 새롭게 commit을 해야지 graph선이 분리된다.