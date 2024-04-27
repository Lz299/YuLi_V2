import request from '@/utils/request'

// 查询评论管理列表
export function listComments(query) {
  return request({
    url: '/community/comments/list',
    method: 'get',
    params: query
  })
}

// 查询评论管理详细
export function getComments(commentsId) {
  return request({
    url: '/community/comments/' + commentsId,
    method: 'get'
  })
}

// 新增评论管理
export function addComments(data) {
  return request({
    url: '/community/comments',
    method: 'post',
    data: data
  })
}

// 修改评论管理
export function updateComments(data) {
  return request({
    url: '/community/comments',
    method: 'put',
    data: data
  })
}

// 删除评论管理
export function delComments(commentsId) {
  return request({
    url: '/community/comments/' + commentsId,
    method: 'delete'
  })
}
