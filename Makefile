.PHONY: up down build logs clean help dev-up dev-down dev-logs

help: ## 사용 가능한 명령어 목록을 보여줍니다
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

up: ## 컨테이너를 백그라운드에서 실행합니다
	docker compose -f docker/docker-compose.yml up -d
	docker compose -f docker/docker-compose.yml logs -f

down: ## 실행 중인 컨테이너를 중지하고 제거합니다
	docker compose -f docker/docker-compose.yml down
	docker compose -f docker/docker-compose.yml down -v --rmi all

build: ## 컨테이너를 새로 빌드하고 실행합니다
	docker compose -f docker/docker-compose.yml up -d --build

logs: ## 컨테이너 로그를 확인합니다
	docker compose -f docker/docker-compose.yml logs -f

clean: ## 컨테이너, 이미지, 볼륨을 모두 제거합니다
	docker compose -f docker/docker-compose.yml down -v --rmi all

dev-up: ## 개발 환경 컨테이너를 실행합니다
	docker compose -f docker/docker-compose.dev.yml up -d
	docker compose -f docker/docker-compose.dev.yml logs -f 
	
dev-down: ## 개발 환경 컨테이너를 중지합니다
	docker compose -f docker/docker-compose.dev.yml down

dev-logs: ## 개발 환경 컨테이너의 로그를 확인합니다
	docker compose -f docker/docker-compose.dev.yml logs -f 