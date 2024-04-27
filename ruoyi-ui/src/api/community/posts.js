import request from '@/utils/request'

// 查询帖子管理列表
export function listPosts(query) {
  return request({
    url: '/community/posts/list',
    method: 'get',
    params: query
  })
}

// 查询帖子管理详细
export function getPosts(postsId) {
  return request({
    url: '/community/posts/' + postsId,
    method: 'get'
  })
}

// 新增帖子管理
export function addPosts(data) {
  return request({
    url: '/community/posts',
    method: 'post',
    data: data
  })
}

// 修改帖子管理
export function updatePosts(data) {
  return request({
    url: '/community/posts',
    method: 'put',
    data: data
  })
}

// 删除帖子管理
export function delPosts(postsId) {
  return request({
    url: '/community/posts/' + postsId,
    method: 'delete'
  })
}
